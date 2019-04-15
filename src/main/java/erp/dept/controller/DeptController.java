package erp.dept.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.util.DateUtil;
import erp.common.web.JsonResult;
import erp.dept.entity.Dept;
import erp.dept.entity.DeptEmp;
import erp.dept.service.DeptEmpService;
import erp.dept.service.DeptService;
import erp.employee.entity.Employee;
import erp.employee.service.EmployeeService;
import erp.system.entity.User;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService DeptService;
	@Autowired
	private DeptEmpService DeptEmpService;
	
	@RequestMapping("/deptInfo")
	public String empInfo(HttpServletRequest request){
		System.out.println("deptlist");
		return "dept/deptInfo";
	}
	
	@RequestMapping("/findDeptObjects")
	@ResponseBody
	public JsonResult findDeptObjects(String name){
		System.out.println("findDeptObjects");
		Map<String,Object> map = DeptService.findObjects(name);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findDeptObjectById")
	@ResponseBody
	public JsonResult finddeptObjectById(HttpServletRequest request){
		System.out.println("finddeptObjectById");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer e_id = user.getE_id();
		
		Integer id = DeptEmpService.findObjectByEId(e_id).getDeptno();
		
		System.out.println("部门id:"+id);
		Dept dept = DeptService.findObjectById(id);
		return new JsonResult(dept);
	}
	
	@RequestMapping("/deptemplistM")
	public String emplist(HttpServletRequest request){
		return "dept/deptemplist";
	}
	
	@RequestMapping("/DeptEmpEditUI")
	public String DeptEmpEditUI(HttpServletRequest request){
		return "dept/deptempedit";
	}
	
	@RequestMapping("/findDeptEmpObjects")
	@ResponseBody
	public JsonResult findDeptEmpObjects(Integer employeeid,Integer deptno,Integer pageCurrent){
		System.out.println("findDeptEmpObjects");
		Map<String,Object> map = DeptEmpService.findObjects(employeeid,deptno,pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findDeptEmpObjectById")
	@ResponseBody
	public JsonResult findDeptEmpObjectById(Integer id){
		System.out.println("findDeptEmpObjectById");
		DeptEmp deptEmp = DeptEmpService.findObjectById(id);
		return new JsonResult(deptEmp);
	}
	
	
	@RequestMapping("doSaveDeptEmpObject")
	@ResponseBody
	public JsonResult doSaveObject(
			DeptEmp entity){
		DeptEmpService.saveObject(entity);
		return new JsonResult();
	}
	
	@RequestMapping("doUpdateDeptEmpObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			DeptEmp entity,
			HttpServletRequest request){
		//假设有用户登录,可以从session中获得用户信息
		User user=(User)
		request.getSession()
		.getAttribute("user");
		entity.setModifiedUser(user.getU_username());
		entity.setModifiedTime(DateUtil.getToday());
		DeptEmpService.updateObject(entity);
		return new JsonResult();
	}
	
	
}
