package erp.system.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.common.exception.ServiceException;
import erp.system.dao.UserRoleDao;
import erp.system.service.UserRoleService;




@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	
	@Resource
	private UserRoleDao userRoleDao;
	
	
	/** 查询用户角色*/
	public int findRoleByUserId(Integer userId) {
		if(userId==null){
			throw new ServiceException("请输入用户ID！");
		}
		int roleId = userRoleDao.findRoleByUserId(userId);
		return roleId;
	}


	public int insertObject(Integer userId, Integer roleId) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
