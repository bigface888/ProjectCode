package com.atguigu.atcrowdfunding.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.impl.util.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.LockRecordList;
import com.atguigu.atcrowdfunding.bean.Page;
import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.RoleService;
import com.atguigu.atcrowdfunding.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes( Integer[] userid ) {
		AJAXResult result = new AJAXResult();
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userids", userid);
			userService.deleteUsers(map);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/deletes1")
	public Object deletes1( Integer[] lrlid ) {
		AJAXResult result = new AJAXResult();
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("lrlids", lrlid);
			userService.deleteLrls(map);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete( Integer id ) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			userService.deleteUserById(id);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete1")
	public Object delete1( Integer id ) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			userService.deleteRecordById(id);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update( User user) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			userService.updateUser(user);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	//修改登录者个人信息
	@ResponseBody
	@RequestMapping("/updateLoginer")
	public Object updateLoginer( User user,HttpSession session,HttpServletRequest request) {
		AJAXResult result = new AJAXResult();
		
		try {
			User loginUser=(User) request.getSession().getAttribute("loginUser");
			loginUser.setUsername(user.getUsername());
			loginUser.setUserpswd(user.getUserpswd());
			loginUser.setTelephone(user.getTelephone());
			session.setAttribute("loginUser",loginUser);
			userService.updateLoginUser(user);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	//审核通过
	@ResponseBody
	@RequestMapping("/ok")
	public Object checkOk( TempAuthorithCheck tac) {
		AJAXResult result = new AJAXResult();
			long checkTime=System.currentTimeMillis();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tac.setChecktime(sdf.format(checkTime));
			tac.setCheckresult(1);
			userService.updateTac(tac);
			result.setSuccess(true);
		    return result;
	}
	//审核不通过
	@ResponseBody
	@RequestMapping("/error")
	public Object checkError( TempAuthorithCheck tac) {
		AJAXResult result = new AJAXResult();
			long checkTime=System.currentTimeMillis();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tac.setChecktime(sdf.format(checkTime));
			tac.setCheckresult(0);
			userService.updateTac(tac);
			result.setSuccess(true);
     		return result;
	}
	
	@RequestMapping("/edit")
	public String edit( int id, Model model ) {
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	//授权审核
	@RequestMapping("/checkAuthority")
	public String checkAuthority(Integer id,Model model) {
		TempAuthorithCheck tac=userService.queryById1(id);
		model.addAttribute("tac", tac);
		return "user/checkAuthority";
	}
	
	@RequestMapping("/assign")
	public String assign( Integer id, Model model ) {
		
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		
		List<Role> roles = roleService.queryAll();
		
		List<Role> assingedRoles = new ArrayList<Role>();
		List<Role> unassignRoles = new ArrayList<Role>();
		
		// 获取关系表的数据
		List<Integer> roleids = userService.queryRoleidsByUserid(id);
		for ( Role role : roles ) {
			if ( roleids.contains(role.getId())) {
				assingedRoles.add(role);
			} else {
				unassignRoles.add(role);
			}
		}
		
		model.addAttribute("assingedRoles", assingedRoles);
		model.addAttribute("unassignRoles", unassignRoles);
		
		return "user/assign";
	}
	
	
	@ResponseBody
	@RequestMapping("/doAssign")
	public Object doAssign( Integer userid, Integer[] unassignroleids ,HttpServletRequest request) {
		AJAXResult result = new AJAXResult();
		try {
			// 增加关系表数据
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			map.put("roleids", unassignroleids);
			userService.insertUserRoles(map);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/dounAssign")
	public Object dounAssign( Integer userid, Integer[] assignroleids ) {
		AJAXResult result = new AJAXResult();
		
		try {
			// 删除关系表数据
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			map.put("roleids", assignroleids);
			userService.deleteUserRoles(map);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert( User user ) {
		AJAXResult result = new AJAXResult();
		Integer[] roleids=new Integer[1];
		Map<String,Object> map=new HashMap<String, Object>();
		roleids[0]=1;
		try {
			userService.insertUser(user);
			int id=user.getId();
			map.put("userid", id);
			map.put("roleids", roleids);
			userService.insertUserRoles(map);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pageno, Integer pagesize ) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			
			// 分页查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			
			List<User> users = userService.pageQueryData( map );
			// 当前页码			
			// 总的数据条数
			int totalsize = userService.pageQueryCount( map );
			// 最大页码（总页码）
			int totalno = 0;
			if ( totalsize % pagesize == 0 ) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			
			// 分页对象
			Page<User> userPage = new Page<User>();
			userPage.setDatas(users);
			userPage.setTotalno(totalno);
			userPage.setTotalsize(totalsize);
			userPage.setPageno(pageno);
			
			result.setData(userPage);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
	}
	
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}
	
	@RequestMapping("/checkUser")
	public String checkUser() {
		return "user/checkUser";
	}
	
	@RequestMapping("/recordList")
	public String recordList() {
		return "user/recordList";
	}
	
	@RequestMapping("/authorityCheck")
	public String authorityCheck() {
		return "user/authorityCheck";
	}
	
	//审核用户
	@ResponseBody
	@RequestMapping("/ajaxCheckUser")
	public Object checkUser(String queryText, Integer pageno, Integer pagesize) {
		AJAXResult result = new AJAXResult();
		try {
			// 分页查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno - 1) * pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);

			List<User> users = userService.queryCheckUser(map);
			// 当前页码
			// 总的数据条数
			int totalsize = userService.queryCheckUserCount(map);
			// 最大页码（总页码）
			int totalno = 0;
			if (totalsize % pagesize == 0) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}

			// 分页对象
			Page<User> userPage = new Page<User>();
			userPage.setDatas(users);
			userPage.setTotalno(totalno);
			userPage.setTotalsize(totalsize);
			userPage.setPageno(pageno);

			result.setData(userPage);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	/*
	 * 用户授权审核
	 */
	@ResponseBody
	@RequestMapping("/ajaxAuthorityCheck")
	public Object ajaxAuthorityCheck(String queryText, Integer pageno, Integer pagesize) {
		AJAXResult result = new AJAXResult();
		try {
			// 分页查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno - 1) * pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);

			List<TempAuthorithCheck> tacs = userService.queryAuthorityCheck(map);
			// 当前页码
			// 总的数据条数
			int totalsize = userService.queryAuthorityCheckCount(map);
			// 最大页码（总页码）
			int totalno = 0;
			if (totalsize % pagesize == 0) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}

			// 分页对象
			Page<TempAuthorithCheck> userPage = new Page<TempAuthorithCheck>();
			userPage.setDatas(tacs);
			userPage.setTotalno(totalno);
			userPage.setTotalsize(totalsize);
			userPage.setPageno(pageno);

			result.setData(userPage);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	/*
	 *访客记录
	 */
	@ResponseBody
	@RequestMapping("/ajaxRecordList")
	public Object ajaxRecordList(String queryText, Integer pageno, Integer pagesize) {
		AJAXResult result = new AJAXResult();
		try {
			// 分页查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno - 1) * pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);

			List<LockRecordList> lrls = userService.queryRecordList(map);
			// 当前页码
			// 总的数据条数
			int totalsize = userService.queryRecordListCount(map);
			// 最大页码（总页码）
			int totalno = 0;
			if (totalsize % pagesize == 0) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}

			// 分页对象
			Page<LockRecordList> userPage = new Page<LockRecordList>();
			userPage.setDatas(lrls);
			userPage.setTotalno(totalno);
			userPage.setTotalsize(totalsize);
			userPage.setPageno(pageno);

			result.setData(userPage);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
}
