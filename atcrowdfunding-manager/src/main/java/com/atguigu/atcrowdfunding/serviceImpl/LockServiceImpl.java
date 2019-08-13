package com.atguigu.atcrowdfunding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.Lock;
import com.atguigu.atcrowdfunding.dao.LockDao;
import com.atguigu.atcrowdfunding.service.LockService;
@Service
public class LockServiceImpl implements LockService{
	@Autowired
	private LockDao lockDao;
	
	public List<Lock> queryAllLock() {
		return lockDao.queryAllLock();
	}
	
	public Lock queryTsgInfo() {
		return lockDao.queryTsgInfo();
	}

	public List<Lock> queryAllLock1() {
		return lockDao.queryAllLock1();
	}

}
