package erp.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import erp.common.dao.BaseDao;
import erp.system.entity.User;

public interface UserDao extends BaseDao<User> {

	
	User findObjectByName(@Param("username")String username);
	User findObjectById(@Param("id")Integer id);
	
	List<User> findPageObjects(@Param("startIndex")Integer startIndex,@Param("pageSize") Integer pageSize);
	
	int getRowCount();
	int validById(
			@Param("ids")String[] ids,
			@Param("valid")int valid);
	/*
	int validById(@Param("id")Integer id,@Param("valid")Integer valid);
	*//**
	 * 查询用户得权�??
	 * @param userId
	 *//*
	List<String> findUserPermissions(Integer userId);
	*/
	
	

}
