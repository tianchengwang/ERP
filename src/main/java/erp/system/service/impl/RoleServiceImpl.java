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
		throw new NullPointerException("添加角色，角色对象不能为空!");
		//保存角色信息
		int i = roleDao.insertObject(role);
		if(i!=1)
		throw new RuntimeException("添加角色失败！");
		//保存角色菜单关系
		String menuIds[]=menuIdList.split(",");
/*		Map<String, Object> map = new HashMap<String,Object>();
		map.put("roleId", role.getId());
		map.put("menuIds", menuIds);*/
	
	}
	public Map<String, Object> findMapById(Integer roleId) {
		if(roleId==null)
		throw new ServiceException("角色id不能为空！");
		
		Role sysRole=
		roleDao.findObjectById(roleId);
		if(sysRole==null)
		throw new ServiceException("角色信息查询失败！");
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("SysRole", sysRole);
		return map;
	}

	public void updateRole(Role role,String menuIdList) {
		if(role==null)
		throw new ServiceException("角色对象不能为空！");
		
		int i = roleDao.updateObject(role);   //更新角色名称和备注
		if(i!=1) 
		throw new ServiceException("更新角色信息失败！");
		//更新角色菜单关系   - 先删除后添加
		
		
		String[] menuIds=menuIdList.split(",");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("roleId", role.getR_id());
		map.put("menuIds", menuIds);
		
	}
	/**
	 * 删除角色，删除前先判断是否有用户占用此角色，如果有，那么此角色不能删除
	 * 如果可以删除，删除角色后，角色和菜单的关系也要删除
	 */
/*	public void deleteObject(Integer roleId) {
		if(roleId==null)
		throw new NullPointerException("删除角色信息，角色id不能为空！");
		//查看是否有用户占用此角色
		int counts = userRoleDao.isUsedByUser(roleId);
		if(counts!=0)
		throw new RuntimeException("该角色已被用户占用，不能删除！");
		//删除角色信息
		int i = roleDao.deleteObject(roleId);
		if(i!=1)
		throw new RuntimeException("删除角色信息失败！");
		//删除角色菜单关系
		
	
	}*/



	public List<Map<String, Object>> findZtreeNodes() {
		// TODO Auto-generated method stub
		return null;
	}



	public void deleteObject(Integer roleId) {
		// TODO Auto-generated method stub
		
	}
}
