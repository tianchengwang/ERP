package erp.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements 
HandlerInterceptor{

	/**
	 * 最后执行的方法
	 * arg3:处理器方法所抛出的异常。
	 */
	public void afterCompletion(
			HttpServletRequest arg0, 
			HttpServletResponse arg1,
			Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}

	/**
	 * 处理器的方法已经执行完毕，正准备将处理结果(
	 * ModelAndView)返回给DispatcherServlet之前，
	 * 执行postHandle方法（可以在该方法里面，修改
	 * 返回结果）。
	 * arg3:处理器返回的处理结果。
	 */
	public void postHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, Object arg2, 
			ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle()");
	}
	
	/**
	 * DispatcherServlet会先调用拦截器的
	 * preHandle方法，如果该方法的返回值为true,
	 * 则继续向后执行（调用后续的拦截器或者是处理器）。
	 * arg2(了解):处理器的方法对象（可以通过java反射
	 * 来获取处理器的方法名，参数类型等等）。
	 */
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object arg2) throws Exception {
		System.out.println("开始session验证...");
		//获得session
		HttpSession session =
				request.getSession();
		//通过session对象获取数据
		Object obj = session.getAttribute("user");
		if(obj == null){
			System.out.println(
					"没有登录，重定向到登录页面");
			//没有登录,重定向到登录页面
			response.sendRedirect("toLogin.do");
			return false;
		}
		//登录过，则允许访问。
		System.out.println("登录过了，允许访问");
		return true;
	}

}





