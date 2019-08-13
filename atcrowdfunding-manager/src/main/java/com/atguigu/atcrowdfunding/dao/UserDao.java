package com.atguigu.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.atguigu.atcrowdfunding.bean.LockRecordList;
import com.atguigu.atcrowdfunding.bean.TempAuthorithCheck;
import com.atguigu.atcrowdfunding.bean.User;

public interface UserDao {

	@Select("select * from t_user")
	List<User> queryAll();
	@Select("select * from t_user where username=#{username} and telephone=#{telephone}")
	User queryByNT(@Param("username") String username,@Param("telephone") String telephone);
	@Select("select * from t_user where username= #{username} and userpswd = #{userpswd}")
	User query4Login(User user);
	@Select("select * from t_user where wxid=#{wxid}")
	User queryByWxid(String wxid);
	
	List<User> pageQueryData(Map<String, Object> map);
	
	List<User> queryCheckUser(Map<String,Object> map);
	
	int pageQueryCount(Map<String, Object> map);
	
	int queryCheckUserCount(Map<String,Object> map);
	
	int queryCheckCount();
	
	int queryAuthorityCount();
	
	void insertUser(User user);
	
	void wxInsertUser(User user);

	User queryById(int id);

	void updateUser(User user);
	
	void updateLoginUser(User user);
	
	void deleteUserById(Integer id);

	void deleteUsers(Map<String, Object> map);
	
	void deleteLrls(Map<String,Object> map);

	void insertUserRoles(Map<String, Object> map);

	void deleteUserRoles(Map<String, Object> map);

	@Select("select roleid from t_user_role where userid = #{userid}")
	List<Integer> queryRoleidsByUserid(Integer id);
	
    void wxInsertApplyUser(TempAuthorithCheck tac);
    
    List<TempAuthorithCheck> queryAuthorityCheck(Map<String, Object> map);
    
    int queryAuthorityCheckCount(Map<String, Object> map);
    
    List<LockRecordList> queryRecordList(Map<String, Object> map);
    
    int queryRecordListCount(Map<String, Object> map);
    
    User queryUserByIdcard(String idcard);
    
    void bangDingWx(Map<String,Object> map);
    @Select("select * from t_temp_authority_check where id = #{id}")
    TempAuthorithCheck queryById1(Integer id);
    
    void updateTac(TempAuthorithCheck tac);
    @Delete("delete from t_lock_record_list where id=#{id}")
    void deleteRecordById(Integer id);
}
