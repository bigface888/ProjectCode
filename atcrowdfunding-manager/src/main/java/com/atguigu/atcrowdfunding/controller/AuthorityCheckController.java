package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Page;
import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.ApplyAuthorityService;

@Controller
@RequestMapping("/authorityCheck")
public class AuthorityCheckController {
	
	@Autowired
	private ApplyAuthorityService authorityService;

	@RequestMapping("/ok")
	public String ok() {
		return "authority/okList";
	}
	@RequestMapping("/error")
	public String error() {
		return "authority/errorList";
	}
	@ResponseBody
	@RequestMapping("/okList")
	public Object okList( String queryText, Integer pageno, Integer pagesize ) {
		AJAXResult result = new AJAXResult();
		try {
			// ��ҳ��ѯ
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			
			List<TempAuthorithCheck> tacs = authorityService.queryOkList( map );
			// ��ǰҳ��			
			// �ܵ���������
			int totalsize = authorityService.queryOkCount(map);
			// ���ҳ�루��ҳ�룩
			int totalno = 0;
			if ( totalsize % pagesize == 0 ) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			
			// ��ҳ����
			Page<TempAuthorithCheck> userPage = new Page<TempAuthorithCheck>();
			userPage.setDatas(tacs);
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
	
	@ResponseBody
	@RequestMapping("/errorList")
	public Object errorList( String queryText, Integer pageno, Integer pagesize ) {
		AJAXResult result = new AJAXResult();
		try {
			// ��ҳ��ѯ
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			
			List<TempAuthorithCheck> tacs = authorityService.queryErrorList( map );
			// ��ǰҳ��			
			// �ܵ���������
			int totalsize = authorityService.queryErrorCount(map);
			// ���ҳ�루��ҳ�룩
			int totalno = 0;
			if ( totalsize % pagesize == 0 ) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			
			// ��ҳ����
			Page<TempAuthorithCheck> userPage = new Page<TempAuthorithCheck>();
			userPage.setDatas(tacs);
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
}
