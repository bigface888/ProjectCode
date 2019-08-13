package com.atguigu.atcrowdfunding.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.LockRecordList;
import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.UserDao;
import com.atguigu.atcrowdfunding.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<User> queryAll() {
		return userDao.queryAll();
	}

	public User query4Login(User user) {
		return userDao.query4Login(user);
	}

	public List<User> pageQueryData(Map<String, Object> map) {
		return userDao.pageQueryData(map);
	}
	
	public List<User> queryCheckUser(Map<String,Object> map){
		return userDao.queryCheckUser(map);
	}
	public int pageQueryCount(Map<String, Object> map) {
		return userDao.pageQueryCount(map);
	}
	public int queryCheckUserCount(Map<String,Object> map) {
		return userDao.queryCheckUserCount(map);
	}
	public int queryCheckCount() {
		return userDao.queryCheckCount();
	}

	public int queryAuthorityCount() {
		return userDao.queryAuthorityCount();
	}
	
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public User queryById(int id) {
		return userDao.queryById(id);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public void updateTac(TempAuthorithCheck tac) {
		userDao.updateTac(tac);
	}

	public void deleteUserById(Integer id) {
		userDao.deleteUserById(id);
	}

	public void deleteUsers(Map<String, Object> map) {
		userDao.deleteUsers(map);
	}

	public void deleteUserRoles(Map<String, Object> map) {
		userDao.deleteUserRoles(map);
	}

	public void insertUserRoles(Map<String, Object> map) {
		userDao.insertUserRoles(map);
	}

	public List<Integer> queryRoleidsByUserid(Integer id) {
		return userDao.queryRoleidsByUserid(id);
	}

	public void wxInsertUser(User user) {
		userDao.wxInsertUser(user);
	}

	public void wxInsertApplyUser(TempAuthorithCheck tac) {
		userDao.wxInsertApplyUser(tac);
	}

	public List<TempAuthorithCheck> queryAuthorityCheck(Map<String, Object> map) {
		return userDao.queryAuthorityCheck(map);
	}

	public int queryAuthorityCheckCount(Map<String, Object> map) {
		return userDao.queryAuthorityCheckCount(map);
	}

	public List<LockRecordList> queryRecordList(Map<String, Object> map) {
		return userDao.queryRecordList(map);
	}

	public int queryRecordListCount(Map<String, Object> map) {
		return userDao.queryRecordListCount(map);
	}

	

	

	public TempAuthorithCheck queryById1(Integer id) {
		return userDao.queryById1(id);
	}

	public void updateLoginUser(User user) {
		userDao.updateLoginUser(user);
	}

	public User queryByNT(String username,String telephone) {
		return userDao.queryByNT(username,telephone);
	}
	
	public User queryByWxid(String wxid) {
		return userDao.queryByWxid(wxid);
	}

	public void deleteRecordById(Integer id) {
		 userDao.deleteRecordById(id);
	}

	public void deleteLrls(Map<String, Object> map) {
		userDao.deleteLrls(map);
	}

	
	
	
}
