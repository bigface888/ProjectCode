package com.atguigu.atcrowdfunding.bean;

import java.math.BigInteger;

public class User {
	private int id;//用户ID
	private String username;//用户名
	private String userpswd;//登录密码
	private String telephone;//电话号码
	private int level;//用户级别：3：超级管理员  2：管理员  1：普通用户
	private String wxid;//微信账号
	private int ischeck;//是否是校内人员 0：校外  1：校内
	
	public int getIscheck() {
		return ischeck;
	}
	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}
	public String getWxid() {
		return wxid;
	}
	public void setWxid(String wxid) {
		this.wxid = wxid;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getUserpswd() {
		return userpswd;
	}
	public void setUserpswd(String userpswd) {
		this.userpswd = userpswd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
