package erp.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.common.exception.ServiceException;
import erp.common.util.DateUtil;
import erp.common.web.PageObject;
import erp.system.dao.RoleDao;
import erp.system.dao.UserDao;
import erp.system.dao.UserRoleDao;
import erp.system.entity.User;
import erp.system.entity.UserRole;
import erp.system.service.UserService;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private UserRoleDao userRoleDao;

	public User findObjectByName(String username,String password) {
		if(username==null||"".equals(username)){
			throw new ServiceException("�û�������Ϊ�գ�");
		}
		if(password==null||"".equals(password)){
			throw new ServiceException("��������Ϊ�գ�");
		}
		User user = userDao.findObjectByName(username);
		
		if(user==null){
			throw new ServiceException("�û������ڣ�");
		}
		if(!password.equals(user.getU_password())){
			throw new ServiceException("�������");
		}
		return user;
	}

	public void saveObject(User user) {
		if(user==null){
			throw new ServiceException("�����û���Ϣ���û�������Ϊ�գ�");
		}
		user.setCreatedTime(DateUtil.getToday());
		user.setCreatedUser("admin");
		//�����û���Ϣ
		int i = userDao.insertObject(user);
		if(i==-1)
			throw new ServiceException("�����û���Ϣʧ�ܣ�");
		user = userDao.findObjectByName(user.getU_username());
		//�����û���ɫ��Ϣ
		UserRole userRole = new UserRole();
		userRole.setCreatedTime(DateUtil.getToday());
		userRole.setCreatedUser("admin");
		userRole.setU_id(user.getU_id());
		userRole.setR_id(2);
		int j = userRoleDao.insertObject(userRole);
		if(j==-1)
			throw new ServiceException("�����û���ɫʧ�ܣ�");
	}

	public Map<String, Object> findUserById(Integer userId) {
		if(userId==null)
			throw new ServiceException("�û�id����Ϊ�գ�");
		User user = userDao.findObjectById(userId);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user", user);
		return map;
	}
	
	public Map<String, Object> findPageObjects(Integer pageCurrent) {
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(userDao.getRowCount());	
	    pageObject.setPageCurrent(pageCurrent);
	    int pageSize=4;
	    int startIndex=(pageCurrent-1)*pageSize;
	    pageObject.setPageSize(pageSize);
	    pageObject.setStartIndex(startIndex);
	    
		List<User> list = 
		userDao.findPageObjects(startIndex,pageSize);
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageObject",pageObject);
		return map;
	}
	
	
	public void updateObject(User user) {
		if(user==null)
			throw new ServiceException("�û�������Ϊ�գ�");
		user.setModifiedTime(DateUtil.getToday());
		//�����û���Ϣ
		int i = userDao.updateObject(user);
		if(i!=1)
			throw new ServiceException("�޸ĸ����û���Ϣʧ�ܣ�");
		
	}
	
	public void validById(String idStr, Integer valid) {
		
		System.out.println("valid="+valid);
		//1.�Բ�������ҵ����֤(���ϵͳ���ݴ�����)
		if(idStr==null||idStr.trim().length()==0)
		throw new ServiceException("����ѡ��һ��");
		if(valid!=0&&valid!=1)
		throw new ServiceException("validֵ������0����1");
		//2.���ַ�������Ϊ����(���ѡ�е�����idֵ)
		String[] ids=idStr.split(",");
		//3.ִ�����û���õĸ��²���
		userDao.validById(ids,valid);
	
	
}
	
	/*public List<Map<String, Object>> findSysRoles() {
		List<Map<String, Object>> list = roleDao.findObjects();
		if(list==null || list.size()==0){
			throw new ServiceException("��ȡ��ɫ�б�ʧ�ܣ�");
		}
		return list;
	}*/
	

	
	/** ����id��ѯ�û���Ϣ*//*
	public Map<String,Object> findUserById(Integer userId) {
		
	}*/
	/*public void updateObject(SysUser user,String roleIds) {
		if(user==null)
		throw new ServiceException("�û�������Ϊ�գ�");
		String saltStr = UUID.randomUUID().toString();   //������ֵ
		ByteSource salt = ByteSource.Util.bytes(saltStr);
		String pwd = new SimpleHash("MD5",user.getU_password(),salt).toString();
		user.setU_password(pwd);
		
		//�����û���Ϣ
		int i = userDao.updateObject(user);
		if(i!=1)
		throw new ServiceException("�޸ĸ����û���Ϣʧ�ܣ�");
		//�����û���ɫ��Ϣ  - ��ɾ�����߹�ϵ������Ӷ��߹�ϵ
		String[] roleArrayIds=roleIds.split(",");
		int counts =userRoleDao.deleteUserRoles(user.getU_id());
		if(counts<1)
		throw new RuntimeException("�����û���ɫ��Ϣʧ�ܣ�");
		int rows = userRoleDao.insertObject(user.getU_id(),roleArrayIds);
		if(rows!=roleArrayIds.length)
		throw new ServiceException("�����û���ɫʧ�ܣ�");
	}
	public void validById(Integer userId, Integer valid) {
		if(userId==null)
		throw new ServiceException("�޸��û�״̬���û�id����Ϊ�գ�");
		if(valid==null)
		throw new ServiceException("�޸��û�״̬��validֵ����Ϊ�գ�");
		int i = userDao.validById(userId,valid);
		if(i==-1)
		throw new ServiceException("�л��û����ý���״̬ʧ�ܣ�");
	}
	*//**��ѯ�û�������Ȩ��*//*
	public List<String> findUserPermissions(Integer userId) {
		if(userId==null)
		throw new ServiceException("�û�id����Ϊ�գ�");
		return userDao.findUserPermissions(userId);
	}
	*//**��ѯ�û��˵�*//*
	public List<Map<String, Object>> findUserMenus(Integer userId) {
		if(userId==null)
		throw new ServiceException("�û�ID����Ϊ��");
		return userDao.findUserMenus(userId);
	}
	public Map<String, Object> findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
