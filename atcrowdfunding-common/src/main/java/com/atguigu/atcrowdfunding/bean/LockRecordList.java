package com.atguigu.atcrowdfunding.bean;
/**
 * 访客记录
 *
 */
public class LockRecordList {
	private Integer id;
	private String username;// 用户名
	private String telephone;//电话号码
	private String lockname;//门禁名称
	private String visitetime;//访问时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLockname() {
		return lockname;
	}
	public void setLockname(String lockname) {
		this.lockname = lockname;
	}
	public String getVisitetime() {
		return visitetime;
	}
	public void setVisitetime(String visitetime) {
		this.visitetime = visitetime;
	}
	
	
}
