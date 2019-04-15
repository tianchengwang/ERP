package erp.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements 
HandlerInterceptor{

	/**
	 * ���ִ�еķ���
	 * arg3:�������������׳����쳣��
	 */
	public void afterCompletion(
			HttpServletRequest arg0, 
			HttpServletResponse arg1,
			Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}

	/**
	 * �������ķ����Ѿ�ִ����ϣ���׼����������(
	 * ModelAndView)���ظ�DispatcherServlet֮ǰ��
	 * ִ��postHandle�����������ڸ÷������棬�޸�
	 * ���ؽ������
	 * arg3:���������صĴ�������
	 */
	public void postHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, Object arg2, 
			ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle()");
	}
	
	/**
	 * DispatcherServlet���ȵ�����������
	 * preHandle����������÷����ķ���ֵΪtrue,
	 * ��������ִ�У����ú����������������Ǵ���������
	 * arg2(�˽�):�������ķ������󣨿���ͨ��java����
	 * ����ȡ�������ķ��������������͵ȵȣ���
	 */
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object arg2) throws Exception {
		System.out.println("��ʼsession��֤...");
		//���session
		HttpSession session =
				request.getSession();
		//ͨ��session�����ȡ����
		Object obj = session.getAttribute("user");
		if(obj == null){
			System.out.println(
					"û�е�¼���ض��򵽵�¼ҳ��");
			//û�е�¼,�ض��򵽵�¼ҳ��
			response.sendRedirect("toLogin.do");
			return false;
		}
		//��¼������������ʡ�
		System.out.println("��¼���ˣ��������");
		return true;
	}

}





