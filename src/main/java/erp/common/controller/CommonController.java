package erp.common.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.entity.Codelibrary;
import erp.common.service.CodeLibraryService;
import erp.common.web.JsonResult;

@Controller
public class CommonController {
	
	@Autowired
	private CodeLibraryService codeLibraryService;
	
	@RequestMapping("/findCodeObjects")
	@ResponseBody
	public JsonResult findCodeObjects(String codeno){
		System.out.println("findCodeObjects");
		List<Codelibrary> list = codeLibraryService.findObjects(codeno);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findCodeObject")
	@ResponseBody
	public JsonResult findCodeObject(String codeno,String itemno){
		System.out.println("codeno:"+codeno+"  itemno:"+itemno);
		System.out.println("findCodeObjects");
		Codelibrary codelibrary = codeLibraryService.findObject(codeno,itemno);
		return new JsonResult(codelibrary);
	}
	
	@RequestMapping("/findShengObjects")
	@ResponseBody
	public JsonResult findShengObjects(){
		System.out.println("findShengObject");
		List<Codelibrary> list = codeLibraryService.findShengObjects();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findShiObjects")
	@ResponseBody
	public JsonResult findShiObjects(String itemno){
		System.out.println("findShiObjects");
		List<Codelibrary> list = codeLibraryService.findShiObjects(itemno);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return new JsonResult(map);
	}
	
	@RequestMapping("/findQuObjects")
	@ResponseBody
	public JsonResult findQuObjects(String itemno){
		System.out.println("findQuObjects");
		List<Codelibrary> list = codeLibraryService.findQuObjects(itemno);
		System.out.println(list);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return new JsonResult(map);
	}
	
	
	
	
	
	
	
}
