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
	
	
	/** ��ѯ�û���ɫ*/
	public int findRoleByUserId(Integer userId) {
		if(userId==null){
			throw new ServiceException("�������û�ID��");
		}
		int roleId = userRoleDao.findRoleByUserId(userId);
		return roleId;
	}


	public int insertObject(Integer userId, Integer roleId) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
