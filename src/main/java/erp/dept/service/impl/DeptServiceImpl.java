package erp.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import erp.common.exception.ServiceException;
import erp.common.web.PageObject;
import erp.dept.dao.DeptDao;
import erp.dept.entity.Dept;
import erp.dept.service.DeptService;
import erp.employee.entity.Employee;



@Service//假如没有指定名字默认id为deptServiceImpl
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao;

	public Map<String, Object> findObjects(String name) {
		
		List<Dept> list= deptDao.findObjects(name);
		//2.获得总记录数,计算总页数,然后进行封装
		//2.1 查询总记录数
		int rowCount=
		deptDao.getRowCount(name);
		//2.3封装分页信息(自己定义PageObject)
		
		Map<String,Object> map=
		new HashMap<String,Object>();
		//3.1封装当前页数据
		map.put("list", list);
		
		return map;
	}

	public Dept findObjectById(Integer id) {
		//1.判定id的有效性
		if(id==null||id<=0)
			throw new ServiceException("id值无效:id="+id);
		//2.根据id查找对应的对象
		Dept dept= deptDao.findObjectById(id);
		//3.判定结果是否正确
		if(dept==null)
			throw new ServiceException("没有找到对应的记录");
		//4.返回结果
		return dept;
	}

	public void saveObject(Dept entity) {
		//1.对参数进行业务验证
		if(entity==null)
			throw new ServiceException("写入的数据不能为空");
		//2.执行写入操作(返回值默认为写入的行数)
		int rows= deptDao.insertObject(entity);
		//3.对结果进行业务判定
		if(rows==-1)
			throw new ServiceException("insert error");
		
	}

	public void updateObject(Dept entity) {
		//1.判定参数的有效性
		if(entity==null)
		throw new ServiceException("被修改的记录不能空");
		//2.执行修改操作
		int rows=deptDao.updateObject(entity);
		//3.根据结果判定是否修改成功
		if(rows!=1)
			throw new RuntimeException("修改失败");
		
	}
	


}
