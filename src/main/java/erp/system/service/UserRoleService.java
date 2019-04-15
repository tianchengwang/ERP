package erp.system.service;


public interface UserRoleService {
	
	int findRoleByUserId(Integer userId);
	int insertObject(Integer userId,Integer roleId);

}
