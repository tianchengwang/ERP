package erp.equipment.controller;


import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.util.DateUtil;
import erp.common.web.JsonResult;
import erp.employee.entity.Employee;
import erp.equipment.entity.Equipment;
import erp.equipment.service.EquipmentService;
import erp.system.entity.User;


@Controller
public class EquipmentController {
	
	@Autowired
	private EquipmentService EquipmentService;
	
	@RequestMapping("/equipmentInfo")
	public String EquipmentInfo(HttpServletRequest request){
		System.out.println("equipmentInfo");
		return "equipment/equipmentInfo";
	}
	
	@RequestMapping("/findequipmentObjects.do")
	@ResponseBody
	public JsonResult findEquipmentObjects(HttpServletRequest request,Integer pageCurrent){
		System.out.println("findequipmentObjects");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer id = user.getE_id();
		System.out.println("用户id:"+id);
		Map<String,Object> map = EquipmentService.findObjects(id,pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findequipmentObjectById.do")
	@ResponseBody
	public JsonResult findEquipmentObjectByEId(Integer id){
		System.out.println("findequipmentObjectById");
		Equipment equipment = EquipmentService.findObjectById(id);
		System.out.println(equipment);
		return new JsonResult(equipment);
	}
	
	@RequestMapping("/UpdateEquipmentObject.do")
	@ResponseBody
	public JsonResult UpdateEquipmentObject(Integer id) throws ParseException{
		System.out.println("findequipmentObjectById");
		Equipment equipment = EquipmentService.findObjectById(id);
		System.out.println(equipment);
		if("已归还".equals(equipment.getStatus())){
			return new JsonResult("已归还，不要再次归还");
		}
		equipment.setStatus("2");
		equipment.setEnddate(DateUtil.getToday());
		equipment.setDays(DateUtil.getTimeSub(equipment.getStartdate(), equipment.getEnddate()));
		EquipmentService.updateObject(equipment);
		System.out.println(equipment);
		return new JsonResult("归还成功！");
	}
	
}
