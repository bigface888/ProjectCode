package com.atguigu.atcrowdfunding.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.dao.RoleDao;
import com.atguigu.atcrowdfunding.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;


	public List<Role> pageQueryData(Map<String, Object> map) {
		return roleDao.pageQueryData(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		return roleDao.pageQueryCount(map);
	}

	public List<Role> queryAll() {
		return roleDao.queryAll();
	}

	public void insertRolePermission(Map<String, Object> paramMap) {
		roleDao.deleteRolePermissions(paramMap);
		roleDao.insertRolePermission(paramMap);
	}

	public void insertRoleName(Role role) {
		roleDao.insertRoleName(role);
	}

	public void deleteRoles(Map<String,Object> map) {
		roleDao.deleteRoles(map);
	}

	public void deleteRoleById(Integer id) {
		roleDao.deleteRoleById(id);
	}

	public Role queryById(Integer id) {
		return roleDao.queryById(id);
	}

	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}
	


}
