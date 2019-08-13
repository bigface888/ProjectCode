package com.atguigu.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.LockRecordList;
import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;
import com.atguigu.atcrowdfunding.bean.User;

public interface UserService {

	List<User> queryAll();

	User query4Login(User user);

	List<User> pageQueryData(Map<String, Object> map);
	
    List<User> queryCheckUser(Map<String,Object> map);
    
	int pageQueryCount(Map<String, Object> map);
	
    int queryCheckUserCount(Map<String,Object> map);
    
    int queryCheckCount();
    
    int queryAuthorityCount(); 
    
	void insertUser(User user);

	User queryById(int id);

	void updateUser(User user);
	
	void updateLoginUser(User user);
	
	void updateTac(TempAuthorithCheck tac);

	void deleteUserById(Integer id);

	void deleteUsers(Map<String, Object> map);
    
	void deleteLrls(Map<String,Object> map);
	
	void deleteUserRoles(Map<String, Object> map);

	void insertUserRoles(Map<String, Object> map);

	List<Integer> queryRoleidsByUserid(Integer id);
	
    void wxInsertUser(User user);
    
    void wxInsertApplyUser(TempAuthorithCheck tac);
    
    List<TempAuthorithCheck> queryAuthorityCheck(Map<String, Object> map);
    
    int queryAuthorityCheckCount(Map<String, Object> map);
    
    List<LockRecordList> queryRecordList(Map<String, Object> map);
    
    int queryRecordListCount(Map<String, Object> map);
    TempAuthorithCheck queryById1(Integer id);
    
    User queryByNT(String username,String telephone);
    User queryByWxid(String wxid);
    void deleteRecordById(Integer id);
}
