package com.atguigu.atcrowdfunding.bean;

import java.util.List;

public class Page<T> {

	private List<T> datas;//分页数据
	private int pageno;//当前页码
	private int totalno;//最大页码
	private int totalsize;//总的数据条数
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getTotalno() {
		return totalno;
	}
	public void setTotalno(int totalno) {
		this.totalno = totalno;
	}
	public int getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}
	
	
}
