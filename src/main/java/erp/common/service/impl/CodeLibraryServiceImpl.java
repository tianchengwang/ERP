package erp.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.common.dao.CodeLibraryDao;
import erp.common.entity.Codelibrary;
import erp.common.service.CodeLibraryService;

@Service
public class CodeLibraryServiceImpl implements CodeLibraryService {

	@Autowired
	private CodeLibraryDao codeLibraryDao;
	
	public List<Codelibrary> findObjects(String codeno) {
		List<Codelibrary> list = codeLibraryDao.findObjects(codeno);
		return list;
	}

	public Codelibrary findObject(String codeno, String itemno) {
		Codelibrary codeLibrary = codeLibraryDao.findObject(codeno, itemno);
		return codeLibrary;
	}

	public List<Codelibrary> findShengObjects() {
		List<Codelibrary> list = codeLibraryDao.findShengObjects();
		return list;
	}

	public List<Codelibrary> findShiObjects(String itemno) {
		List<Codelibrary> list = codeLibraryDao.findShiObjects(itemno);
		return list;
	}

	public List<Codelibrary> findQuObjects(String itemno) {
		List<Codelibrary> list = codeLibraryDao.findQuObjects(itemno);
		return list;
	}

	public void saveObject(Codelibrary entity) {
		// TODO Auto-generated method stub
		
	}

	public void updateObject(Codelibrary entity) {
		// TODO Auto-generated method stub
		
	}

	/*public Map<String, Object> findObjects(String name,Integer valid,int pageCurrent) {
		//1.通过dao对象的方法获取当前页项目信息
		//1.1定义每页最多显示2条数据
		int pageSize=5;
		//1.2计算当前页开始查找的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//1.3开始查询当前页的数据
		List<Employee> list= EmployeeDao.findObjects(name,valid,startIndex,pageSize);
		//2.获得总记录数,计算总页数,然后进行封装
		//2.1 查询总记录数
		int rowCount= EmployeeDao.getRowCount(name,valid);
		//2.3封装分页信息(自己定义PageObject)
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		//3.将数据封装到map(两个对象需要传回页面)
		Map<String,Object> map = new HashMap<String,Object>();
		//3.1封装当前页数据
		map.put("list", list);
		//3.2封装分页对象信息
		map.put("pageObject", pageObject);
		return map;
	}*/
	

}

