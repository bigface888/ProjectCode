package com.atguigu.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;

public interface ApplyAuthorityService {

	void insertApply(TempAuthorithCheck tac);
	
	List<TempAuthorithCheck> queryOkList(Map<String,Object> map);
	
	int queryOkCount(Map<String,Object> map);
	
    List<TempAuthorithCheck> queryErrorList(Map<String,Object> map);
	
	int queryErrorCount(Map<String,Object> map);
}
