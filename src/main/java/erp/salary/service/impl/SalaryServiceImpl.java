package erp.salary.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.common.exception.ServiceException;
import erp.common.web.PageObject;
import erp.dept.entity.Dept;
import erp.dept.entity.DeptEmp;
import erp.employee.dao.EmployeeDao;
import erp.employee.entity.Employee;
import erp.salary.dao.SalaryDao;
import erp.salary.entity.Salary;
import erp.salary.service.SalaryService;
import erp.work.entity.Work;
import erp.work.service.WorkService;




@Service//假如没有指定名字默认id为SalaryServiceImpl
public class SalaryServiceImpl implements SalaryService {

	@Resource
	private SalaryDao SalaryDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private WorkService workService;

	public Map<String, Object> findObjects(int pageCurrent) {
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<Salary> list=
		SalaryDao.findObjects(startIndex,pageSize);
		int rowCount=
		SalaryDao.getRowCount();
		for(Salary sa : list){
			Integer no = sa.getEmployeeID();
			Employee emp = employeeDao.findObjectById(no);
			sa.setAttribute(emp.getEmployeeName());
			sa.setAttribute1(emp.getEmployeeID());
		}
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		//3.将数据封装到map(两个对象需要传回页面)
		Map<String,Object> map=
		new HashMap<String,Object>();
		//3.1封装当前页数据
		map.put("list", list);
		//3.2封装分页对象信息
		map.put("pageObject", pageObject);
		return map;
	}

	public Salary findObjectById(Integer id) {
		//1.判定id的有效性
		if(id==null||id<=0)
			throw new ServiceException("id值无效:id="+id);
		//2.根据id查找对应的对象
		Salary Salary= SalaryDao.findObjectById(id);
		//3.判定结果是否正确
		if(Salary==null)
			throw new ServiceException("没有找到对应的记录");
		//4.返回结果
		return Salary;
	}

	public void saveObject(Salary entity) {
		//1.对参数进行业务验证
		if(entity==null)
			throw new ServiceException("写入的数据不能为空");
		//2.执行写入操作(返回值默认为写入的行数)
		int rows= SalaryDao.insertObject(entity);
		//3.对结果进行业务判定
		if(rows==-1)
			throw new ServiceException("insert error");
		
	}

	public void updateObject(Salary entity) {
		//1.判定参数的有效性
		if(entity==null)
		throw new ServiceException("被修改的记录不能空");
		//2.执行修改操作
		int rows=SalaryDao.updateObject(entity);
		//3.根据结果判定是否修改成功
		if(rows!=1)
			throw new RuntimeException("修改失败");
		
	}


	public Salary findObjectByEId(Integer id) {
		//1.判定id的有效性
		if(id==null||id<=0)
			throw new ServiceException("id值无效:id="+id);
		//2.根据id查找对应的对象
		Salary Salary= SalaryDao.findObjectByEId(id);
		//3.判定结果是否正确
		if(Salary==null)
			throw new ServiceException("没有找到对应的记录");
		Work work = workService.findObjectById(id);
		double total = work.getWorkdays()*Salary.getBasicssalary()+work.getAdddays()*Salary.getBasicssalary()*3.0
						+work.getTraveldays()*Salary.getTravelexpenses()+Salary.getRanksalary()+Salary.getHousesalary()+Salary.getMealsalary();
		Salary.setTotalsalary(total);
		Employee emp = employeeDao.findObjectById(id);
		Salary.setAttribute(emp.getEmployeeName());
		
		
		//4.返回结果
		return Salary;
	}
	


}
