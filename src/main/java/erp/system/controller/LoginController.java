package erp.system.controller;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import erp.common.exception.ServiceException;
import erp.common.web.JsonResult;
import erp.system.entity.User;
import erp.system.service.UserService;

@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/toLogin.do")
	public String login(HttpServletRequest request){
		System.out.println("loginUI.do");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println("移除前："+user);
		session.removeAttribute("user");
		User user1 = (User)session.getAttribute("user");
		System.out.println("移除后："+user1);
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username,String userpwd,
			HttpSession session){
		System.out.println(username+"/"+userpwd);
		User user = userService.findObjectByName(username,userpwd);
		//绑订数据，用于session验证。
		session.setAttribute("user", user);
		return "redirect:IndexUI.do";
	    
	}
	
	@ExceptionHandler
	public ModelAndView handle(Exception e,
			HttpServletRequest request){
		System.out.println("handle()");
		if(e instanceof ServiceException){
			//应用异常
			request.setAttribute("message",
					e.getMessage());
			System.out.println(request.getAttribute("message"));
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message",e.getMessage());
			return mav;
		}
		//系统异常
		return new ModelAndView("error");
	}
}
