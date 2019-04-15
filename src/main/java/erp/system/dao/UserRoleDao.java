package erp.system.dao;

import org.apache.ibatis.annotations.Param;

import erp.system.entity.UserRole;

public interface UserRoleDao {
	
	Integer findRoleByUserId(@Param("userId")Integer userId);
	int insertObject(UserRole userRole);
	/*int isUsedByUser(@Param("roleId")Integer roleId);
	int insertObject(@Param("userId")Integer userId,
			@Param("roleIds")String[] roleIds);
	int deleteUserRoles(Integer userId);*/
}
