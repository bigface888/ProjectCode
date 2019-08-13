package com.atguigu.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.Role;

public interface RoleService {
	List<Role> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	List<Role> queryAll();

	void insertRolePermission(Map<String, Object> paramMap);
	
	void insertRoleName(Role role);
	
	void deleteRoles(Map<String,Object> map);
	
	void deleteRoleById(Integer id);
	
	Role queryById(Integer id);
	
	void updateRole(Role role);

}
