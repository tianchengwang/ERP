package erp.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.common.exception.ServiceException;
import erp.common.web.PageObject;
import erp.system.dao.RoleDao;
import erp.system.dao.UserRoleDao;
import erp.system.entity.Role;
import erp.system.service.RoleService;



@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	
	@Resource
	private UserRoleDao userRoleDao;
	public Map<String, Object> findObjects(String name,
			Integer pageCurrent) {
		System.out.println("name="+name);
		System.out.println("pageCurrent="+pageCurrent);
		Integer pageSize=3;
		Integer startIndex=(pageCurrent-1)*pageSize;
		List<Role> list=roleDao.findPageObjects(name,startIndex,pageSize);
		
		PageObject pageObject=new PageObject();
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(roleDao.getRowCounts(name));	
		Map<String,Object> map=new HashMap<String, Object>();
		System.out.println("list.size="+list.size());
		map.put("list", list);
		map.put("pageObject",pageObject);
		return map;
	}
	
	

	public void saveObject(Role role,String menuIdList) {
		if(role==null)
		throw new NullPointerException("��ӽ�ɫ����ɫ������Ϊ��!");
		//�����ɫ��Ϣ
		int i = roleDao.insertObject(role);
		if(i!=1)
		throw new RuntimeException("��ӽ�ɫʧ�ܣ�");
		//�����ɫ�˵���ϵ
		String menuIds[]=menuIdList.split(",");
/*		Map<String, Object> map = new HashMap<String,Object>();
		map.put("roleId", role.getId());
		map.put("menuIds", menuIds);*/
	
	}
	public Map<String, Object> findMapById(Integer roleId) {
		if(roleId==null)
		throw new ServiceException("��ɫid����Ϊ�գ�");
		
		Role sysRole=
		roleDao.findObjectById(roleId);
		if(sysRole==null)
		throw new ServiceException("��ɫ��Ϣ��ѯʧ�ܣ�");
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("SysRole", sysRole);
		return map;
	}

	public void updateRole(Role role,String menuIdList) {
		if(role==null)
		throw new ServiceException("��ɫ������Ϊ�գ�");
		
		int i = roleDao.updateObject(role);   //���½�ɫ���ƺͱ�ע
		if(i!=1) 
		throw new ServiceException("���½�ɫ��Ϣʧ�ܣ�");
		//���½�ɫ�˵���ϵ   - ��ɾ�������
		
		
		String[] menuIds=menuIdList.split(",");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("roleId", role.getR_id());
		map.put("menuIds", menuIds);
		
	}
	/**
	 * ɾ����ɫ��ɾ��ǰ���ж��Ƿ����û�ռ�ô˽�ɫ������У���ô�˽�ɫ����ɾ��
	 * �������ɾ����ɾ����ɫ�󣬽�ɫ�Ͳ˵��Ĺ�ϵҲҪɾ��
	 */
/*	public void deleteObject(Integer roleId) {
		if(roleId==null)
		throw new NullPointerException("ɾ����ɫ��Ϣ����ɫid����Ϊ�գ�");
		//�鿴�Ƿ����û�ռ�ô˽�ɫ
		int counts = userRoleDao.isUsedByUser(roleId);
		if(counts!=0)
		throw new RuntimeException("�ý�ɫ�ѱ��û�ռ�ã�����ɾ����");
		//ɾ����ɫ��Ϣ
		int i = roleDao.deleteObject(roleId);
		if(i!=1)
		throw new RuntimeException("ɾ����ɫ��Ϣʧ�ܣ�");
		//ɾ����ɫ�˵���ϵ
		
	
	}*/



	public List<Map<String, Object>> findZtreeNodes() {
		// TODO Auto-generated method stub
		return null;
	}



	public void deleteObject(Integer roleId) {
		// TODO Auto-generated method stub
		
	}
}
