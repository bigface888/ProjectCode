package com.atguigu.atcrowdfunding.bean;
/**
 * ��ʱ��Ȩ��˱�
 *
 */
public class TempAuthorithCheck {
	private String id;
	private String username;//�û���
	private String receptname;//�Ӵ�������
	private String telephone;//���˵绰����
	private String receptphone;//�Ӵ��˵绰����
	private String lockname;//������������
	private String applytime;//����ʱ��
	private String checktime;//���ʱ��
	private int checkresult;//��˽�� 0����˲�ͨ����1�����ͨ��
	private String lefttime;//��������ʱ��
	private String visitecause;//����Ե��
	
	
	
	
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
