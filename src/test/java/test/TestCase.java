package test;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import erp.common.entity.Codelibrary;
import erp.common.service.CodeLibraryService;
import erp.employee.service.EmployeeService;



public class TestCase {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml");
	}
	@Test
	public void testFindObjects(){
		CodeLibraryService codeLibraryService = ctx.getBean("codeLibraryServiceImpl", CodeLibraryService.class);
		Codelibrary code = codeLibraryService.findObject("Sex","1");
		System.out.println(code);
	}
	@After
	public void closeCtx(){
		ctx.close();
	}
	
}
