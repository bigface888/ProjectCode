package com.atguigu.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.atguigu.atcrowdfunding.bean.Role;

public interface RoleDao {

	List<Role> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	@Select("select * from t_role")
	List<Role> queryAll();

	void insertRolePermission(Map<String, Object> paramMap);

	void deleteRolePermissions(Map<String, Object> paramMap);

	void insertRoleName(Role role);
	
	void deleteRoles(Map<String,Object> map);
	
	void deleteRoleById(Integer id);
	
	Role queryById(Integer id);
	
	void updateRole(Role role);
}
