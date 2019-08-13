package com.atguigu.atcrowdfunding.bean;
/**
 * 门锁表
 *
 */
public class Lock {
	private String locknumber;//门锁设备号  主键
	private String lockname; //门锁名称
	private int id;//门锁编号
	private String css;//门锁样式
	private String logo;//门锁标致
	private int flag;//门禁类别，1：表示有访问权限  0：表示无访问权限
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getLocknumber() {
		return locknumber;
	}
	public void setLocknumber(String locknumber) {
		this.locknumber = locknumber;
	}
	public String getLockname() {
		return lockname;
	}
	public void setLockname(String lockname) {
		this.lockname = lockname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
