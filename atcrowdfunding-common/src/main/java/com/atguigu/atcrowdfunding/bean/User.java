package com.atguigu.atcrowdfunding.bean;

import java.math.BigInteger;

public class User {
	private int id;//�û�ID
	private String username;//�û���
	private String userpswd;//��¼����
	private String telephone;//�绰����
	private int level;//�û�����3����������Ա  2������Ա  1����ͨ�û�
	private String wxid;//΢���˺�
	private int ischeck;//�Ƿ���У����Ա 0��У��  1��У��
	
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
