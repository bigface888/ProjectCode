package com.atguigu.atcrowdfunding.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;
import com.atguigu.atcrowdfunding.dao.ApplyAuthorityDao;
import com.atguigu.atcrowdfunding.service.ApplyAuthorityService;
@Service
public class ApplyAuthorityImpl implements ApplyAuthorityService{

	@Autowired
	private ApplyAuthorityDao aaDao;
	public void insertApply(TempAuthorithCheck tac) {
		aaDao.insertApply(tac);
	}
	public List<TempAuthorithCheck> queryOkList(Map<String, Object> map) {
		return aaDao.queryOkList(map);
	}
	public int queryOkCount(Map<String, Object> map) {
		return aaDao.queryOkCount(map);
	}
	
	public List<TempAuthorithCheck> queryErrorList(Map<String, Object> map) {
		return aaDao.queryErrorList(map);
	}
	public int queryErrorCount(Map<String, Object> map) {
		return aaDao.queryErrorCount(map);
	}

}
