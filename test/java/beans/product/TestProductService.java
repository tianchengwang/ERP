package beans.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import petbuy.products.entity.Product;
import petbuy.products.service.ProductService;
import petbuy.system.entity.User;
import petbuy.system.service.UserRoleService;
import petbuy.system.service.UserService;

public class TestProductService {
     ClassPathXmlApplicationContext ctx;
	 @Before
	 public void init(){
		 ctx=new ClassPathXmlApplicationContext(
		"spring-mvc.xml","spring-mybatis.xml");
	 }
	 /*@Test
	 public void testSaveObject(){
		 ProductService ProductService=
		 ctx.getBean("ProductServiceImpl",
				 ProductService.class);
		 Product p=new Product();
		 p.setName("东欧游");
		 p.setCode("tt-20171116-CN-BJ-001");
		 p.setBeginDate(new Date());//java.util.Date
		 p.setEndDate(new Date());
		 p.setValid(1);
		 p.setNote("东欧游....");
		 ProductService.saveObject(p);
		 System.out.println("insert ok");
	 }
	 
	 @Test
	 public void testFindObjects(){
		 ProductService ProductService=
				 ctx.getBean("ProductServiceImpl",
						 ProductService.class);
	     
	 }*/
	 
	/* @Test
	 public void testFindObjectsById(){
		 ProductService ProductService=
				 ctx.getBean("ProductServiceImpl",
						 ProductService.class);
		 Product pro = ProductService.findObjectById(1);
		 System.out.println(pro);
	     
	 }*/
	/* @Test
	 public void testFindObjects(){
		 ProductService ProductService=
				 ctx.getBean("ProductServiceImpl",
						 ProductService.class);
		 Map<String, Object> map = ProductService.findPageObjects("01010",null,1);
		 List list = (List)map.get("list");
		 System.out.println(list);
	     
	 }*/
	/* @Test
	 public void testFindRoleByUserId(){
		 UserRoleService userRoleService=
				 ctx.getBean("userRoleService",
						 UserRoleService.class);
		 int roleId = userRoleService.findRoleByUserId(1);
		 
		 System.out.println(roleId);
	     
	 }*/
	 @Test
	 public void testSaveUser(){
		 UserService UserService=
				 ctx.getBean("userService",
						 UserService.class);
		 User user = new User();
		 user.setU_username("tcwang");
		 user.setU_password("123456");
		 user.setU_email("tcwang@163.com");
		 user.setU_mobile("18712344321");
		 user.setU_address("黑龙江鹤岗");
		 UserService.saveObject(user);
		 
	 }
	 
	 @After
	 public void destroy(){
		 ctx.close();
	 }
}
