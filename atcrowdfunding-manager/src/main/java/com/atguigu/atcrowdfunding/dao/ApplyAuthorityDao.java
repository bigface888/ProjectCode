package com.atguigu.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;

public interface ApplyAuthorityDao {
	void insertApply(TempAuthorithCheck tac);
	
	List<TempAuthorithCheck> queryOkList(Map<String,Object> map);
	
	int queryOkCount(Map<String,Object> map);
	
    List<TempAuthorithCheck> queryErrorList(Map<String,Object> map);
	
	int queryErrorCount(Map<String,Object> map);
}
