package com.atguigu.atcrowdfunding.bean;
/**
 * 临时授权审核表
 *
 */
public class TempAuthorithCheck {
	private String id;
	private String username;//用户名
	private String receptname;//接待人姓名
	private String telephone;//本人电话号码
	private String receptphone;//接待人电话号码
	private String lockname;//申请门锁名称
	private String applytime;//到访时间
	private String checktime;//审核时间
	private int checkresult;//审核结果 0：审核不通过：1：审核通过
	private String lefttime;//门锁开启时间
	private String visitecause;//访问缘由
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getChecktime() {
		return checktime;
	}
	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}
	public int getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(int checkresult) {
		this.checkresult = checkresult;
	}
	public String getlefttime() {
		return lefttime;
	}
	public void setLefttime(String lefttime) {
		this.lefttime = lefttime;
	}
	public String getReceptname() {
		return receptname;
	}
	public void setReceptname(String receptname) {
		this.receptname = receptname;
	}
	public String getReceptphone() {
		return receptphone;
	}
	public void setReceptphone(String receptphone) {
		this.receptphone = receptphone;
	}
	public String getVisitecause() {
		return visitecause;
	}
	public void setVisitecause(String visitecause) {
		this.visitecause = visitecause;
	}
	
	
	
}
