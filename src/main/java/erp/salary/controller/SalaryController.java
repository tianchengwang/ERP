package erp.salary.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.util.DateUtil;
import erp.common.web.JsonResult;
import erp.dept.entity.DeptEmp;
import erp.salary.entity.Salary;
import erp.salary.service.SalaryService;
import erp.system.entity.User;

@Controller
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@RequestMapping("/salaryInfo")
	public String empInfo(HttpServletRequest request){
		System.out.println("SalaryInfo");
		return "salary/salaryInfo";
	}
	
	@RequestMapping("/findSalaryObjects.do")
	@ResponseBody
	public JsonResult findSalaryObjects(String name,Integer valid,Integer pageCurrent){
		System.out.println("findSalaryObjects");
		Map<String,Object> map = salaryService.findObjects(pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findSalaryObjectByEId.do")
	@ResponseBody
	public JsonResult findSalaryObjectById(HttpServletRequest request){
		System.out.println("findSalaryObjectByEId");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id = user.getE_id();
		System.out.println("员工id:"+id);
		Salary Salary = salaryService.findObjectByEId(id);
		return new JsonResult(Salary);
	}

	@RequestMapping("/salarylistM")
	public String salarylistM(HttpServletRequest request){
		return "salary/salaryemplist";
	}
	
	@RequestMapping("/SalaryEditUI")
	public String SalaryEditUI(HttpServletRequest request){
		return "salary/salaryedit";
	}
	
	@RequestMapping("/findSalaryObjectById")
	@ResponseBody
	public JsonResult findDeptEmpObjectById(Integer id){
		System.out.println("findDeptEmpObjectById");
		Salary salary = salaryService.findObjectById(id);
		return new JsonResult(salary);
	}
	
	
	@RequestMapping("doSaveSalaryObject")
	@ResponseBody
	public JsonResult doSaveObject(
			Salary entity){
		salaryService.saveObject(entity);
		return new JsonResult();
	}
	
	@RequestMapping("doUpdateSalaryObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			Salary entity,
			HttpServletRequest request){
		//假设有用户登录,可以从session中获得用户信息
		System.out.println(entity);
		User user=(User)
		request.getSession()
		.getAttribute("user");
		entity.setModifiedUser(user.getU_username());
		entity.setModifiedTime(DateUtil.getToday());
		salaryService.updateObject(entity);
		return new JsonResult();
	}
	
	
	
}
