package erp.message.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import erp.common.web.JsonResult;
import erp.employee.entity.Employee;
import erp.employee.service.EmployeeService;
import erp.message.entity.Message;
import erp.message.service.MessageService;
import erp.system.entity.User;


@Controller
public class MessageController {
	
	
	@Resource
	private MessageService messageService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/messageMlist")
	public String messageMlist(){
		System.out.println("messageMlist");
		return "message/messageMList"; 
	}
	
	@RequestMapping("/questionUI")
	public ModelAndView questionUI(HttpServletRequest request){
		System.out.println("questionUI");
		
		return new ModelAndView("message/question"); 
	}
	
	@RequestMapping("/insertMessage")
	@ResponseBody
	public JsonResult insertMessage(Message message,HttpServletRequest request){
		System.out.println(message);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id = user.getE_id();
		Employee emp = employeeService.findObjectById(id);
		message.setM_name(emp.getEmployeeName());
		messageService.insertMessage(message);
		return new JsonResult();
	}
	
	@RequestMapping("/doFindQuestionObjects")
	@ResponseBody
	public JsonResult doFindMessageObjects(HttpServletRequest request){
		
		Map<String,Object> map = messageService.findObjects(null,1);
		return  new JsonResult(map);
	}
	
	@RequestMapping("/doFindQuestionMObjects")
	@ResponseBody
	public JsonResult doFindMessageMObjects(String type,int pageCurrent){
		Map<String,Object> map = messageService.findObjects(type,pageCurrent);
		return  new JsonResult(map);
	}
	
	
	@RequestMapping("/doFindMessageObjectById")
	@ResponseBody
	public JsonResult doFindMessageObjectById(HttpServletRequest request){
		String id = request.getParameter("id");
		System.out.println(id);
		Integer p_id = Integer.parseInt(id);
		Map<String,Object> map= new HashMap<String, Object>();
		Message message = messageService.findObjectById(p_id);
		map.put("object", message);
		//将获得的数据封装到JsonResult对象
		return new JsonResult(map);
	}
	
	@RequestMapping("/MessageEditUI")
	public String editUI(){
		return "message/message_edit";
	}
	
	@RequestMapping("/doUpdateMessageObject")
	@ResponseBody
	public JsonResult doUpdateObject(Message message){
		messageService.updateObject(message);
		//将获得的数据封装到JsonResult对象
		return new JsonResult();
	}
	
	@RequestMapping("/deleteMessageObject")
	@ResponseBody
	public JsonResult deleteMessageObject(Integer id){
		messageService.deleteMessageObject(id);
		//将获得的数据封装到JsonResult对象
		return new JsonResult();
	}
	
}
