package erp.work.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.web.JsonResult;
import erp.system.entity.User;
import erp.work.entity.Work;
import erp.work.service.WorkService;

@Controller
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	@RequestMapping("/workInfo")
	public String workInfo(HttpServletRequest request){
		System.out.println("workInfo");
		return "work/workInfo";
	}
	
	@RequestMapping("/findworkObjects.do")
	@ResponseBody
	public JsonResult findWorkObjects(Integer pageCurrent){
		System.out.println("findworkObjects");
		Map<String,Object> map = workService.findObjects(null,pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findWorkObjectByEId.do")
	@ResponseBody
	public JsonResult findWorkObjectByEId(HttpServletRequest request){
		System.out.println("findWorkObjectByEId");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id = user.getE_id();
		System.out.println("用户id:"+id);
		Work Work = workService.findObjectById(id);
		System.out.println(Work);
		return new JsonResult(Work);
	}
	
	
	
	
}
