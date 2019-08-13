package com.atguigu.atcrowdfunding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.atguigu.atcrowdfunding.bean.Lock;

public interface LockDao {
	@Select("select * from t_lock where flag=0")
	List<Lock> queryAllLock();
	
	@Select("select * from t_lock where flag=1")
	List<Lock> queryAllLock1();
	
	@Select("select * from t_lock where id = 1")
	Lock queryTsgInfo();
}
