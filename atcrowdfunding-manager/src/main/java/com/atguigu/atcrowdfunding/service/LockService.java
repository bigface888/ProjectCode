package com.atguigu.atcrowdfunding.service;

import java.util.List;

import com.atguigu.atcrowdfunding.bean.Lock;

public interface LockService {
	
	List<Lock> queryAllLock();
	
	List<Lock> queryAllLock1();
    Lock  queryTsgInfo();
}
