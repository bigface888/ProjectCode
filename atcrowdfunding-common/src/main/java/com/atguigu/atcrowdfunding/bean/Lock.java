package com.atguigu.atcrowdfunding.bean;
/**
 * ������
 *
 */
public class Lock {
	private String locknumber;//�����豸��  ����
	private String lockname; //��������
	private int id;//�������
	private String css;//������ʽ
	private String logo;//��������
	private int flag;//�Ž����1����ʾ�з���Ȩ��  0����ʾ�޷���Ȩ��
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
