package erp.common.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import erp.employee.entity.Employee;
import erp.employee.service.EmployeeService;
import erp.system.entity.User;
import erp.system.service.UserRoleService;
import erp.system.service.UserService;

@Controller
public class IndexController {
	
	@Resource
	private UserRoleService userRoleService;
	@Resource
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("/IndexUI.do")
	public ModelAndView indexUI(HttpServletRequest request){
		System.out.println("indexUI");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int role = userRoleService.findRoleByUserId(user.getU_id());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		if(role==1){
			mav.setViewName("indexAdmin");
		}
		mav.addObject("user",user);
		return mav;
	}
	
	@RequestMapping("/topUI.do")
	public ModelAndView topUI(HttpServletRequest request){
		System.out.println("topUI");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id= user.getE_id();
		System.out.println("id:"+id);
		Employee emp = employeeService.findObjectById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("top");
		mav.addObject("emp",emp);
		return mav;
	}
	@RequestMapping("/top.do")
	public ModelAndView top(HttpServletRequest request){
		System.out.println("top");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id= user.getE_id();
		Employee emp = employeeService.findObjectById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("topCom");
		mav.addObject("emp",emp);
		return mav;
	}
	
	@RequestMapping("/leftUI.do")
	public String leftUI(HttpServletRequest request){
		System.out.println("leftUI");
		return "left";
	}
	@RequestMapping("/rightUI.do")
	public ModelAndView rightUI(HttpServletRequest request){
		System.out.println("rightUI");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id= user.getE_id();
		Employee emp = employeeService.findObjectById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("right");
		mav.addObject("emp",emp);
		return mav;
	}
	
	
	
}
