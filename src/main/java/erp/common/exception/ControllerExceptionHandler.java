package erp.common.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import erp.common.exception.ServiceException;
import erp.common.web.JsonResult;
/**ͨ����ע����������Ϊһ��ȫ���쳣��������*/
@ControllerAdvice
public class ControllerExceptionHandler {
	/**��spring����ϵͳ�����쳣��,���쳣��
	 * ����ΪServiceException����,��ʱ�ͻ�
	 * �ص��˷���,�����쳣ֵ���ݸ��������,
	 * ��ʱ���ǾͿ����ڴ˷����ж�ҵ���쳣����
	 * ͳһ����,�����װ��jsonResult,Ȼ��
	 * д���ͻ��˸����û�.*/
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult handleServiceException(
			   ServiceException e){
		e.printStackTrace();
		//���쳣��װ��JsonResult
		return new JsonResult(e);
		//this.state=ERROR;
		//this.message=e.getMessage();
	}
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView  handleRuntimeException(RuntimeException e) {
		System.out.println("handleRuntimeException");
		e.printStackTrace();
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("exp", e.getMessage());
		return mv;
	}
}

