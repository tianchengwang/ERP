package erp.system.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import erp.system.entity.User;

public interface UserService {
	
	User findObjectByName(String username,String password);
	
	Map<String,Object> findUserById(Integer userId);
	
	Map<String, Object> findPageObjects(Integer currentPage);
	
	void updateObject(User user);
	void saveObject(User user);
	
	 void validById(
	   		 String idStr,
	   		 Integer valid);
	/*
	void updateObject(User user,String roleIds);
	void validById(Integer userId, Integer valid);
	List<String> findUserPermissions(Integer userId);
	List<Map<String,Object>> findUserMenus(Integer userId);
	List<Map<String, Object>> findSysRoles();*/
	
}


