package com.atguigu.atcrowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.bean.Lock;
import com.atguigu.atcrowdfunding.service.LockService;

@Controller
@RequestMapping("/lock")
public class LockController {

	@Autowired
	private LockService lockService;
	@RequestMapping("/tsgInfo")
	public String tsgInfo(Model model) {
		Lock tsgLock=lockService.queryTsgInfo();
		model.addAttribute("tsgLock", tsgLock);
		return "lock/tsgInfo";
	}
}
