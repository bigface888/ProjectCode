package com.atguigu.atcrowdfunding.bean;
/**
 * �ÿͼ�¼
 *
 */
public class LockRecordList {
	private Integer id;
	private String username;// �û���
	private String telephone;//�绰����
	private String lockname;//�Ž�����
	private String visitetime;//����ʱ��
	
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
