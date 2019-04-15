package erp.apply.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.apply.dao.ApplyDao;
import erp.apply.entity.Apply;
import erp.apply.service.ApplyService;
import erp.common.entity.Codelibrary;
import erp.common.exception.ServiceException;
import erp.common.service.CodeLibraryService;
import erp.common.web.PageObject;
import erp.employee.entity.Employee;




@Service//假如没有指定名字默认id为ApplyServiceImpl
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyDao ApplyDao;
	
	@Autowired
	private CodeLibraryService codeLibraryService;

	public Map<String, Object> findObjects(Integer employeeid,String type,int pageCurrent) {
		//1.通过dao对象的方法获取当前页项目信息
		//1.1定义每页最多显示2条数据
		int pageSize=2;
		//1.2计算当前页开始查找的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//1.3开始查询当前页的数据
		List<Apply> list= ApplyDao.findObjects(employeeid,type,startIndex,pageSize);
		for(Apply apply : list){
			String status = apply.getApplystatus();
			Codelibrary codeE = codeLibraryService.findObject("ApplyType",status);
			apply.setApplystatus(codeE.getItemname());
		}
		
		//2.获得总记录数,计算总页数,然后进行封装
		//2.1 查询总记录数
		int rowCount=
		ApplyDao.getRowCount(type,employeeid);
		//2.3封装分页信息(自己定义PageObject)
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		//3.将数据封装到map(两个对象需要传回页面)
		Map<String,Object> map=
		new HashMap<String,Object>();
		//3.1封装当前页数据
		map.put("list", list);
		//3.2封装分页对象信息
		map.put("pageObject", pageObject);
		return map;
	}

	public Apply findObjectById(Integer applyno) {
		//1.判定id的有效性
		if(applyno==null||applyno<=0)
			throw new ServiceException("id值无效:id="+applyno);
		//2.根据id查找对应的对象
		Apply Apply= ApplyDao.findObjectById(applyno);
		//3.判定结果是否正确
		if(Apply==null)
			throw new ServiceException("没有找到对应的记录");
		//4.返回结果
		return Apply;
	}

	public void saveObject(Apply entity) {
		//1.对参数进行业务验证
		if(entity==null)
			throw new ServiceException("写入的数据不能为空");
		//2.执行写入操作(返回值默认为写入的行数)
		int rows= ApplyDao.insertObject(entity);
		//3.对结果进行业务判定
		if(rows==-1)
			throw new ServiceException("insert error");
		
	}

	public void updateObject(Apply entity) {
		//1.判定参数的有效性
		if(entity==null)
		throw new ServiceException("被修改的记录不能空");
		//2.执行修改操作
		int rows=ApplyDao.updateObject(entity);
		//3.根据结果判定是否修改成功
		if(rows!=1)
			throw new RuntimeException("修改失败");
		
	}

	
	


}
