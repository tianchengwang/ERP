package erp.employee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import erp.common.entity.Codelibrary;
import erp.common.exception.ServiceException;
import erp.common.service.CodeLibraryService;
import erp.common.util.DateUtil;
import erp.common.web.PageObject;
import erp.dept.dao.DeptEmpDao;
import erp.dept.entity.DeptEmp;
import erp.employee.dao.EmployeeDao;
import erp.employee.entity.Employee;
import erp.employee.service.EmployeeService;
import erp.salary.dao.SalaryDao;
import erp.salary.entity.Salary;
import erp.system.dao.UserDao;



@Service//假如没有指定名字默认id为EmployeeServiceImpl
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao EmployeeDao;
	
	@Autowired
	private CodeLibraryService codeLibraryService;
	
	@Autowired
	private DeptEmpDao deptEmpDao;
	
	@Autowired
	private SalaryDao salaryDao;
	
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see erp.employee.service.EmployeeService#findObjects(java.lang.String, java.lang.Integer, int)
	 */
	public Map<String, Object> findObjects(String name,Integer valid,int pageCurrent) {
		//1.通过dao对象的方法获取当前页项目信息
		//1.1定义每页最多显示2条数据
		int pageSize=5;
		//1.2计算当前页开始查找的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//1.3开始查询当前页的数据
		List<Employee> list= EmployeeDao.findObjects(name,valid,startIndex,pageSize);
		
		for(Employee emp : list){
			String education = emp.getEducation();
			Codelibrary codeE = codeLibraryService.findObject("Education",education);
			emp.setEducation(codeE.getItemname());
			
			String sex = emp.getSex();
			Codelibrary codeS = codeLibraryService.findObject("Sex",sex);
			emp.setSex(codeS.getItemname());
			
			String address1 = emp.getNativePlace();
			Codelibrary codeA1 = codeLibraryService.findObject("Address",address1);
			emp.setNativePlace(codeA1.getItemname());
			
			String grade = emp.getGrade();
			Codelibrary codeG = codeLibraryService.findObject("Rank",grade);
			emp.setGrade(codeG.getItemname());
			
		}
		
		
		//2.获得总记录数,计算总页数,然后进行封装
		//2.1 查询总记录数
		int rowCount= EmployeeDao.getRowCount(name,valid);
		//2.3封装分页信息(自己定义PageObject)
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		//3.将数据封装到map(两个对象需要传回页面)
		Map<String,Object> map = new HashMap<String,Object>();
		//3.1封装当前页数据
		map.put("list", list);
		//3.2封装分页对象信息
		map.put("pageObject", pageObject);
		return map;
	}
	
	/**根据id查找project对象*/
	public  Employee findObjectById(Integer id) {
		//1.判定id的有效性
		if(id==null||id<=0)
			throw new ServiceException("id值无效:id="+id);
		//2.根据id查找对应的对象
		Employee emp= EmployeeDao.findObjectById(id);
		
		//3.判定结果是否正确
		if(emp==null)
			throw new ServiceException("没有找到对应的记录");
		//4.返回结果
		return emp;
	}

	/**执行写入操作
	 * @param entity 封装了用户页面上输入的数据
	 * */
	public void saveObject(Employee entity) {
		String cid = entity.getCertID().substring(12);
		String today = DateUtil.getToday().replaceAll("/", "");
		Random ran = new Random();
		int i = ran.nextInt(10);
		String employeeid = today+cid+i;
		entity.setEmployeeID(employeeid);
		//1.对参数进行业务验证
		if(entity==null)
			throw new ServiceException("写入的数据不能为空");
		//2.执行写入操作(返回值默认为写入的行数)
		int rows= EmployeeDao.insertObject(entity);
		//3.对结果进行业务判定
		if(rows==-1)
			throw new ServiceException("insert error");
		
		Employee emp = EmployeeDao.findObjectByEmployeeId(employeeid);
		DeptEmp deptemp = new DeptEmp();
		deptemp.setDeptno(5);
		deptemp.setE_id(emp.getId());
		deptemp.setCreatedTime(DateUtil.getToday());
		deptEmpDao.insertObject(deptemp);
		
		Salary salary = new Salary();
		salary.setEmployeeID(emp.getId());
		salaryDao.insertObject(salary);
		
		
	}
	
	/**执行修改操作
	 * @param entity指向的对象封装了页面上要
	 * 修改的数据.
	 * */
	public void updateObject(Employee entity) {
		//1.判定参数的有效性
		if(entity==null)
		throw new ServiceException("被修改的记录不能空");
		//2.执行修改操作
		int rows=EmployeeDao.updateObject(entity);
		//3.根据结果判定是否修改成功
		if(rows!=1)
			throw new RuntimeException("修改失败");
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
			EmployeeDao.validById(ids,valid);
			userDao.validById(ids, valid);
		
		
	}

	/*public static void main(String[] args) {
		Random ran = new Random();
		int i = ran.nextInt(10);
		System.out.println(i);
	}*/

}
