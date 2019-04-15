package erp.apply.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.apply.entity.Apply;
import erp.apply.service.ApplyService;
import erp.common.util.DateUtil;
import erp.common.web.JsonResult;
import erp.dept.entity.DeptEmp;
import erp.employee.entity.Employee;
import erp.employee.service.EmployeeService;
import erp.equipment.service.EquipmentService;
import erp.system.entity.User;


@Controller
public class ApplyController {
	
	@Autowired
	private ApplyService ApplyService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@RequestMapping("/apply")
	public String ApplyInfo(HttpServletRequest request){
		System.out.println("Applylist");
		return "apply/apply";
	}
	
	@RequestMapping("/applyEditUI")
	public String applyEditUI(HttpServletRequest request){
		System.out.println("applyEditUI");
		return "apply/applyInfo";
	}
	
	@RequestMapping("/findApplyObjects.do")
	@ResponseBody
	public JsonResult findApplyObjects(HttpServletRequest request,String type,Integer pageCurrent){
		System.out.println("findApplyObjects");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id = user.getE_id();
		System.out.println("用户id:"+id);
		Map<String,Object> map = ApplyService.findObjects(id,type,pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findApplyMObjects.do")
	@ResponseBody
	public JsonResult findApplyMObjects(HttpServletRequest request,String type,Integer pageCurrent){
		System.out.println("findApplyMObjects");
		Map<String,Object> map = ApplyService.findObjects(null,type,pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findApplyObjectById.do")
	@ResponseBody
	public JsonResult findApplyObjectByEId(Integer applyno){
		System.out.println("findApplyObjectById");
		Apply apply = ApplyService.findObjectById(applyno);
		System.out.println(apply);
		return new JsonResult(apply);
	}
	
	@RequestMapping("/doSaveApplyObject")
	@ResponseBody
	public JsonResult doSaveObject(HttpServletRequest request,Apply entity){
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id = user.getE_id();
		System.out.println("用户id:"+id);
		entity.setEmployeeID(id);
		Employee emp = employeeService.findObjectById(id);
		entity.setApplyman(emp.getEmployeeName());
		entity.setApplystatus("0");
		entity.setApplytime(DateUtil.getToday());
		entity.setCreatedTime(DateUtil.getToday());
		entity.setCreatedUser(user.getU_username());
		ApplyService.saveObject(entity);
		return new JsonResult();
	}
	
	
	@RequestMapping("doUpdateApplyObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			Apply entity,
			HttpServletRequest request){
		//假设有用户登录,可以从session中获得用户信息
		User user=(User)
		request.getSession()
		.getAttribute("user");
		
		if("2".equals(entity.getApplytype())){
			equipmentService.saveObject(entity);
		}
		entity.setModifiedUser(user.getU_username());
		entity.setModifiedTime(DateUtil.getToday());
		ApplyService.updateObject(entity);
		return new JsonResult();
	}
	
	
	
	@RequestMapping("/applylistM")
	public String applylistM(HttpServletRequest request){
		System.out.println("applyemplist");
		return "apply/applyemplist";
	}
	
	@RequestMapping("/applyEmpEditUI")
	public String applyEmpEditUI(HttpServletRequest request){
		System.out.println("applyemplist");
		return "apply/applyempedit";
	}
	
	@RequestMapping("/findApplyObjectsM.do")
	@ResponseBody
	public JsonResult findApplyObjectsM(String type,Integer pageCurrent){
		System.out.println("findApplyObjectsM");
		Map<String,Object> map = ApplyService.findObjects(null,type,pageCurrent);
		return new JsonResult(map);
	}
	
}
