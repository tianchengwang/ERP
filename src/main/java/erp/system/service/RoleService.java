package erp.system.service;

import java.util.List;
import java.util.Map;

import erp.system.entity.Role;


public interface RoleService {

	Map<String, Object> findObjects(String name, 
			Integer pageCurrent);
	void saveObject(Role role,String menuIdList);
	Map<String,Object> findMapById(Integer roleId);
	void updateRole(Role role,String menuIdList);
	void deleteObject(Integer roleId);
	List<Map<String, Object>> findZtreeNodes();

}
