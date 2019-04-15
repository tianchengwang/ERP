package erp.system.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.web.JsonResult;
import erp.system.entity.User;
import erp.system.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("registerUI.do")
	public String registerUI(){
		System.out.println("registerUI");
		return "register";
	}
	
	
	@RequestMapping("/register")
	@ResponseBody
	public JsonResult register(User user){
		System.out.println(user);
		System.out.println("register");
		userService.saveObject(user);
		return new JsonResult();
	}
	@RequestMapping("/userMlist.do")
	public String userMlist(){
		System.out.println("userMlist");
		return "user/userMList"; 
	}
	
	/**
	 * 用户列表页面
	 *//*
	@RequestMapping("listUI")
	//@RequiresPermissions("sys:user:view")
	public String listUI(){
		return "system/user_list";
	}
	*//**
	 * 查询用户列表
	 */
	@RequestMapping("doFindUserObjects")
	@ResponseBody
	public JsonResult doFindObjects(Integer pageCurrent){
		Map<String, Object> map =
		userService.findPageObjects(pageCurrent);
		return new JsonResult(map);
	}
	
	/**
	 * 跳转到用户编辑页面（新增/修改�?
	 */
	@RequestMapping("UserEditUI")
	public String editUser(){
		return "user/user_edit";
	}
	/**
	 * 根据id查询用户信息，用于回�?
	 */
	@RequestMapping("doFindUserObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		//System.out.println("map="+map);
		Map<String,Object> map=  userService.findUserById(id);
		System.out.println(map.get("user"));
		map.put("object", map.get("user"));
		return new JsonResult(map);
	}
	/**
	 * 修改更新用户信息
	 */
	@RequestMapping("doUpdateUserObject")
	@ResponseBody
	public JsonResult doUpdateObject(User user){
		userService.updateObject(user);
		return new JsonResult();
	}
	
	
	
	/**
	 * 跳转到用户编辑页面（新增/修改�??
	 *//*
	@RequestMapping("editUI")
	public String editUser(){
		return "system/user_edit";
	}
	*//**
	 * 查询�??有角色列�??
	 *//*
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindRoles(){
		List<Map<String, Object>> list = 
		userService.findSysRoles();
		return new JsonResult(list);
	}
	
	*//**
	 * 保存用户
	 *//*
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(User user,String roleIds){
		userService.saveObject(user, roleIds);
		return new JsonResult();
	}
	*//**
	 * 根据id查询用户信息，用于回�??
	 *//*
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer userId){
		Map<String, Object> map = 
		userService.findUserById(userId);
		//System.out.println("map="+map);
		return new JsonResult(map);
	}
	*//**
	 * 修改更新用户信息
	 *//*
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(User user,String roleIds){
		userService.updateObject(user,roleIds);
		return new JsonResult();
	}
	*//**
	 * 启用/禁用
	 *//*
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer userId,Integer valid){
		userService.validById(userId,valid);
		return new JsonResult();
	}*/

}
