package erp.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.common.exception.ServiceException;
import erp.common.web.PageObject;
import erp.dept.dao.DeptDao;
import erp.dept.dao.DeptEmpDao;
import erp.dept.entity.Dept;
import erp.dept.entity.DeptEmp;
import erp.dept.service.DeptEmpService;
import erp.employee.dao.EmployeeDao;
import erp.employee.entity.Employee;



@Service//假如没有指定名字默认id为deptServiceImpl
public class DeptEmpServiceImpl implements DeptEmpService {

	@Resource
	private DeptEmpDao deptEmpDao;
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmployeeDao employeeDao;
	
	public Map<String, Object> findObjects(Integer e_id, Integer deptno, Integer pageCurrent) {
		if(pageCurrent==null){
			pageCurrent=1;
		}
		int pageSize=4;
		int startIndex=(pageCurrent-1)*pageSize;
		List<DeptEmp> list= deptEmpDao.findObjects(deptno,e_id,startIndex,pageSize);
		int rowCount= deptEmpDao.getRowCount(deptno,e_id);
		for(DeptEmp de : list){
			Integer no = de.getDeptno();
			Dept dept = deptDao.findObjectById(no);
			de.setAttribute1(dept.getDeptName());
			Integer id = de.getE_id();
			Employee emp = employeeDao.findObjectById(id);
			de.setAttribute2(emp.getEmployeeName());
		}
		
		
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);

		Map<String,Object> map= new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}

	public DeptEmp findObjectById(Integer id) {
		//1.判定id的有效性
		if(id==null||id<=0)
			throw new ServiceException("id值无效:id="+id);
		//2.根据id查找对应的对象
		DeptEmp deptEmp= deptEmpDao.findObjectById(id);
		Integer e_id = deptEmp.getE_id();
		Employee emp = employeeDao.findObjectById(e_id);
		deptEmp.setAttribute1(emp.getEmployeeName());
	/*	Integer deptno = deptEmp.getDeptno();
		Dept dept = deptDao.findObjectById(deptno);
		deptEmp.setAttribute2(dept.getDeptName());*/
		//3.判定结果是否正确
		if(deptEmp==null)
			throw new ServiceException("没有找到对应的记录");
		//4.返回结果
		return deptEmp;
	}
	
	public DeptEmp findObjectByEId(Integer e_id) {
		//1.判定id的有效性
		if(e_id==null||e_id<=0)
			throw new ServiceException("id值无效:id="+e_id);
		//2.根据id查找对应的对象
		DeptEmp deptEmp= deptEmpDao.findObjectByEId(e_id);
		//3.判定结果是否正确
		if(deptEmp==null)
			throw new ServiceException("没有找到对应的记录");
		//4.返回结果
		return deptEmp;
	}

	public void saveObject(DeptEmp entity) {
		//1.对参数进行业务验证
		if(entity==null)
			throw new ServiceException("写入的数据不能为空");
		//2.执行写入操作(返回值默认为写入的行数)
		int rows= deptEmpDao.insertObject(entity);
		//3.对结果进行业务判定
		if(rows==-1)
			throw new ServiceException("insert error");
	}

	public void updateObject(DeptEmp entity) {
		Integer deptno = entity.getDeptno();
		Dept dept = deptDao.findObjectById(deptno);
		entity.setManager(dept.getDeptleader());
		//1.判定参数的有效性
		if(entity==null)
			throw new ServiceException("被修改的记录不能空");
		//2.执行修改操作
		int rows=deptEmpDao.updateObject(entity);
		//3.根据结果判定是否修改成功
		if(rows!=1)
			throw new RuntimeException("修改失败");
	}

	public void deleteObject(Integer id) {
		if(id==null)
			throw new ServiceException("id不能为空！");
		int i = deptEmpDao.deleteObject(id);
		if(i!=1)
			throw new ServiceException("删除失败！");
	}


}
