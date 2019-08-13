package com.atguigu.atcrowdfunding.Controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Lock;
import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.ApplyAuthorityService;
import com.atguigu.atcrowdfunding.service.ApplyAuthorityService;
import com.atguigu.atcrowdfunding.service.LockService;
import com.atguigu.atcrowdfunding.service.PermissionService;
import com.atguigu.atcrowdfunding.service.RoleService;
import com.atguigu.atcrowdfunding.service.UserService;

@Controller
public class DispatcherController {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private LockService lockService;
	@Autowired
	private ApplyAuthorityService aaService;
	@Autowired
	private RoleService roleService;
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/showLoginInfo")
	public String showLoginInfo() {
		return "loginInfo";
	}
	
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@ResponseBody
	@RequestMapping("/doAJAXLogin")
	public Object doAJAXLogin(User user, HttpSession session) {
		
		AJAXResult result = new AJAXResult();
		
		User dbUser = userService.query4Login(user);
		if ( dbUser != null ) {
			session.setAttribute("loginUser", dbUser);
			int checkCount=userService.queryCheckCount();
			int authorityCount=userService.queryAuthorityCount();
			session.setAttribute("checkCount", checkCount);
			session.setAttribute("authorityCount", authorityCount);
			// 获取用户权限信息
			List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
			Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
			Permission root = null;
			Set<String> uriSet = new HashSet<String>();
			for ( Permission permission : permissions ) {
				permissionMap.put(permission.getId(), permission);
				if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
					uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
				}
			}
			session.setAttribute("authUriSet", uriSet);
			for ( Permission permission : permissions ) {
				Permission child = permission;
				if ( child.getPid() == 0 ) {
					root = permission;
				} else {
					Permission parent = permissionMap.get(child.getPid());
					parent.getChildren().add(child);
				}
			}
			session.setAttribute("rootPermission", root);
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}
	/*
	 * 微信小程序校外验证用户
	 */
     @ResponseBody 
     @RequestMapping("/checkUser")
     public Map<String,Object> checkUser(HttpServletRequest request,HttpServletResponse response) {
    	 Map<String,Object> map=new HashMap<String, Object>();
    	 String wxid=request.getParameter("wxid");
    	 User user=userService.queryByWxid(wxid);
    	 if(user!=null) {
    		 map.put("result", 1);
    	 }else {
    		 map.put("result", 0);
    	 }
    	 return map;
     }
	
	/*
	 * 微信小程序校外新增用户
	 */
     @ResponseBody 
     @RequestMapping("/insertUser")
     public Object insertUser(HttpServletRequest request,HttpServletResponse response) {
    	 Integer[] roleids=new Integer[1];
    	 roleids[0]=1;
    	 Map<String,Object> map=new HashMap<String, Object>();
    	 String username=request.getParameter("username");
    	 String telephone=request.getParameter("telephone");
    	 User user=userService.queryByNT(username,telephone);
    	 String wxid=user.getWxid();
    	 //如果用户的wxid为空，那么把wxid插入
    	 if("".equals(wxid)) {
        	 user.setWxid(request.getParameter("wxid"));
        	 user.setLevel(1);
        	 user.setIscheck(1);
        	 userService.wxInsertUser(user);
        	 map.put("userid", user.getId());
        	 map.put("roleids",roleids);
        	 userService.insertUserRoles(map);
        	 return "ok";
    	 }else {
    		 return "error";
    	 }
    	
     }
     /**
      * 微信小程序校内、外人员申请绑定接口
     * @throws UnsupportedEncodingException 
      */
     @ResponseBody 
     @RequestMapping("/bangDingWx_no")
     public Object bangDingWxNo(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
    	 response.setContentType("text/json;charset=UTF-8");
    	 response.setCharacterEncoding("UTF-8");
    	 Map<String,Object> map=new HashMap<String, Object>();
    	 String wxid=request.getParameter("wxid");
    	 User user=userService.queryByWxid(wxid);
    	 if(user!=null) {
    		 map.put("username", user.getUsername());
    		 map.put("telephone", user.getTelephone());
    	 //绑定成功之后，获取无审核权限的卡包数据
    	 List<Lock> locks=lockService.queryAllLock();
    	 JSONArray array=new JSONArray();
    	 JSONObject jsonObject=null;
    	 Lock lock=null;
    	 for(int i=0;i<locks.size();i++) {
    		 lock=locks.get(i);
    		 jsonObject=new JSONObject();
    		 jsonObject.put("id", lock.getId());
    		 jsonObject.put("name", lock.getLockname());
    		 jsonObject.put("css", lock.getCss());
    		 jsonObject.put("logo", lock.getLogo());
    		 array.add(jsonObject);
    	 }
    	 map.put("array", array);
     }
    	 return map;
     }
     @ResponseBody 
     @RequestMapping("/bangDingWx_yes")
     public Object bangDingWxYes(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
    	 response.setContentType("text/json;charset=UTF-8");
    	 response.setCharacterEncoding("UTF-8");
    	 Map<String,Object> map=new HashMap<String, Object>();
    	 String wxid=request.getParameter("wxid");
    	 User user=userService.queryByWxid(wxid);
    	 if(user!=null) {
    		 map.put("username", user.getUsername());
    		 map.put("telephone", user.getTelephone());
    	 //绑定成功之后，获取无审核权限的卡包数据
    	 List<Lock> locks=lockService.queryAllLock1();
    	 JSONArray array=new JSONArray();
    	 JSONObject jsonObject=null;
    	 Lock lock=null;
    	 for(int i=0;i<locks.size();i++) {
    		 lock=locks.get(i);
    		 jsonObject=new JSONObject();
    		 jsonObject.put("id", lock.getId());
    		 jsonObject.put("name", lock.getLockname());
    		 jsonObject.put("css", lock.getCss());
    		 jsonObject.put("logo", lock.getLogo());
    		 array.add(jsonObject);
    	 }
    	 map.put("array", array);
     }
    	 return map;
     }
     
     /*
      * 微信小程序用户申请授权接口
      */
     @ResponseBody 
     @RequestMapping("/applyAuthority")
     public Object applyAuthority(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 TempAuthorithCheck tac=new TempAuthorithCheck();
    	 String username=request.getParameter("username");
    	 String telephone=request.getParameter("telephone");
    	 String receptname=request.getParameter("receptname");
    	 String receptphone=request.getParameter("receptphone");
    	 String applytime=request.getParameter("applytime");
    	 String lefttime=request.getParameter("lefttime");
    	 String visitecause=request.getParameter("visitecause");
    	 String lockname=request.getParameter("lockname");
    	 tac.setUsername(username);
    	 tac.setTelephone(telephone);
    	 tac.setReceptname(receptname);
    	 tac.setReceptphone(receptphone);
    	 tac.setApplytime(applytime);
    	 tac.setVisitecause(visitecause);
    	 tac.setLockname(lockname);
    	 tac.setLefttime(lefttime);
    	 aaService.insertApply(tac);
    	 return "ok";
     }
}
