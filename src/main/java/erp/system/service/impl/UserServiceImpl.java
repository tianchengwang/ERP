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
			throw new ServiceException("用户名输入为空！");
		}
		if(password==null||"".equals(password)){
			throw new ServiceException("密码输入为空！");
		}
		User user = userDao.findObjectByName(username);
		
		if(user==null){
			throw new ServiceException("用户不存在！");
		}
		if(!password.equals(user.getU_password())){
			throw new ServiceException("密码错误！");
		}
		return user;
	}

	public void saveObject(User user) {
		if(user==null){
			throw new ServiceException("保存用户信息，用户对象不能为空！");
		}
		user.setCreatedTime(DateUtil.getToday());
		user.setCreatedUser("admin");
		//保存用户信息
		int i = userDao.insertObject(user);
		if(i==-1)
			throw new ServiceException("保存用户信息失败！");
		user = userDao.findObjectByName(user.getU_username());
		//保存用户角色信息
		UserRole userRole = new UserRole();
		userRole.setCreatedTime(DateUtil.getToday());
		userRole.setCreatedUser("admin");
		userRole.setU_id(user.getU_id());
		userRole.setR_id(2);
		int j = userRoleDao.insertObject(userRole);
		if(j==-1)
			throw new ServiceException("保存用户角色失败！");
	}

	public Map<String, Object> findUserById(Integer userId) {
		if(userId==null)
			throw new ServiceException("用户id不能为空！");
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
			throw new ServiceException("用户对象不能为空！");
		user.setModifiedTime(DateUtil.getToday());
		//更新用户信息
		int i = userDao.updateObject(user);
		if(i!=1)
			throw new ServiceException("修改更新用户信息失败！");
		
	}
	
	public void validById(String idStr, Integer valid) {
		
		System.out.println("valid="+valid);
		//1.对参数进行业务验证(提高系统的容错能力)
		if(idStr==null||idStr.trim().length()==0)
		throw new ServiceException("至少选择一项");
		if(valid!=0&&valid!=1)
		throw new ServiceException("valid值必须是0或者1");
		//2.将字符串解析为数组(获得选中的所有id值)
		String[] ids=idStr.split(",");
		//3.执行启用或禁用的更新操作
		userDao.validById(ids,valid);
	
	
}
	
	/*public List<Map<String, Object>> findSysRoles() {
		List<Map<String, Object>> list = roleDao.findObjects();
		if(list==null || list.size()==0){
			throw new ServiceException("获取角色列表失败！");
		}
		return list;
	}*/
	

	
	/** 根据id查询用户信息*//*
	public Map<String,Object> findUserById(Integer userId) {
		
	}*/
	/*public void updateObject(SysUser user,String roleIds) {
		if(user==null)
		throw new ServiceException("用户对象不能为空！");
		String saltStr = UUID.randomUUID().toString();   //生成盐值
		ByteSource salt = ByteSource.Util.bytes(saltStr);
		String pwd = new SimpleHash("MD5",user.getU_password(),salt).toString();
		user.setU_password(pwd);
		
		//更新用户信息
		int i = userDao.updateObject(user);
		if(i!=1)
		throw new ServiceException("修改更新用户信息失败！");
		//更新用户角色信息  - 先删除二者关系，再添加二者关系
		String[] roleArrayIds=roleIds.split(",");
		int counts =userRoleDao.deleteUserRoles(user.getU_id());
		if(counts<1)
		throw new RuntimeException("更新用户角色信息失败！");
		int rows = userRoleDao.insertObject(user.getU_id(),roleArrayIds);
		if(rows!=roleArrayIds.length)
		throw new ServiceException("更新用户角色失败！");
	}
	public void validById(Integer userId, Integer valid) {
		if(userId==null)
		throw new ServiceException("修改用户状态，用户id不能为空！");
		if(valid==null)
		throw new ServiceException("修改用户状态，valid值不能为空！");
		int i = userDao.validById(userId,valid);
		if(i==-1)
		throw new ServiceException("切换用户启用禁用状态失败！");
	}
	*//**查询用户得所有权限*//*
	public List<String> findUserPermissions(Integer userId) {
		if(userId==null)
		throw new ServiceException("用户id不能为空！");
		return userDao.findUserPermissions(userId);
	}
	*//**查询用户菜单*//*
	public List<Map<String, Object>> findUserMenus(Integer userId) {
		if(userId==null)
		throw new ServiceException("用户ID不能为空");
		return userDao.findUserMenus(userId);
	}
	public Map<String, Object> findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
