package erp.employee.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import erp.common.web.JsonResult;
import erp.employee.entity.Employee;
import erp.employee.service.EmployeeService;
import erp.system.entity.User;
import erp.system.service.UserRoleService;
import erp.system.service.UserService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/emplist")
	public String emplist(HttpServletRequest request){
		System.out.println("emplist");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println(user);
		return "employee/emplist";
	}
	
	@RequestMapping("/empInfo")
	public String empInfo(HttpServletRequest request){
		System.out.println("emplist");
		return "employee/empInfo";
	}
	
	@RequestMapping("/findEmpObjects.do")
	@ResponseBody
	public JsonResult findEmpObjects(String name,Integer valid,Integer pageCurrent){
		System.out.println("findEmpObjects");
		Map<String,Object> map = employeeService.findObjects(name,valid,pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findEmpObjectById.do")
	@ResponseBody
	public JsonResult findEmpObjectById(HttpServletRequest request){
		System.out.println("findEmpObjectById");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id = user.getE_id();
		System.out.println("id:"+id);
		Employee emp = employeeService.findObjectById(id);
		System.out.println(emp);
		return new JsonResult(emp);
	}
	
	@RequestMapping("/findEmpObjectByIdM.do")
	@ResponseBody
	public JsonResult findEmpObjectByIdM(Integer id){
		Employee emp = employeeService.findObjectById(id);
		System.out.println(emp);
		return new JsonResult(emp);
	}
	
	
	@RequestMapping("EmployeeeditUI")
	public String editUI(){
		return "employee/employeeedit";
	}
	/**执行添加操作
	 * var params={"name":"A","code":"tt20170807xxxx",..}
	 * @param entity 对象会封装页面上传入的参数值
	 * 页面上参数的名字和entity对象中属性的值
	 * 一致时会实现自动注入操作.
	 * */
	@RequestMapping("doSaveEmployeeObject")
	@ResponseBody
	public JsonResult doSaveObject(
			Employee entity){
		employeeService.saveObject(entity);
		return new JsonResult();
	}
	
	@RequestMapping("doUpdateEmployeeObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			Employee entity,
			HttpServletRequest request){
		//假设有用户登录,可以从session中获得用户信息
		/*User user=(User)
		request.getSession()
		.getAttribute("user");
		entity.setModifiedUser(user.getUsername());
		*/
		employeeService.updateObject(entity);
		return new JsonResult();
	}
	@RequestMapping("doEmpValidById")
	@ResponseBody
	public JsonResult doValidById(
			String checkedIds,
			Integer valid){
		System.out.println(
				"checkedIds="+checkedIds);
		employeeService.validById(checkedIds,valid);
		return new JsonResult();
		//this.message="ok"
		//this.state=SUCCESS
	}
	
}
