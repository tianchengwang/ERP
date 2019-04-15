package erp.equipment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import erp.apply.entity.Apply;
import erp.common.exception.ServiceException;
import erp.common.util.DateUtil;
import erp.common.web.PageObject;
import erp.equipment.dao.EquipmentDao;
import erp.equipment.entity.Equipment;
import erp.equipment.service.EquipmentService;



@Service//假如没有指定名字默认id为EquipmentServiceImpl
public class EquipmentServiceImpl implements EquipmentService {

	@Resource
	private EquipmentDao equipmentDao;

	public Map<String, Object> findObjects(Integer employeeid,int pageCurrent) {
		//1.通过dao对象的方法获取当前页项目信息
		//1.1定义每页最多显示2条数据
		int pageSize=2;
		//1.2计算当前页开始查找的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//1.3开始查询当前页的数据
		List<Equipment> list= equipmentDao.findObjects(employeeid,startIndex,pageSize);
		for(Equipment e:list){
			if("1".equals(e.getStatus())){
				e.setStatus("借用中");
			}
			if("2".equals(e.getStatus())){
				e.setStatus("已归还");
			}
		}
		//2.获得总记录数,计算总页数,然后进行封装
		//2.1 查询总记录数
		int rowCount=
		equipmentDao.getRowCount(employeeid);
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

	public Equipment findObjectById(Integer id) {
		//1.判定id的有效性
		if(id==null||id<=0)
			throw new ServiceException("id值无效:id="+id);
		//2.根据id查找对应的对象
		Equipment Equipment= equipmentDao.findObjectById(id);
		if("1".equals(Equipment.getStatus())){
			Equipment.setStatus("借用中");
		}
		if("2".equals(Equipment.getStatus())){
			Equipment.setStatus("已归还");
		}
		//3.判定结果是否正确
		if(Equipment==null)
			throw new ServiceException("没有找到对应的记录");
		//4.返回结果
		return Equipment;
	}

	public void saveObject(Apply apply) {
		
		
		Equipment entity = new Equipment();
		entity.setEmployeeID(apply.getEmployeeID());
		entity.setEquipmentno(apply.getApplycontent());
		entity.setStartdate(DateUtil.getToday());
		entity.setStatus("1");
		//1.对参数进行业务验证
		if(entity==null)
			throw new ServiceException("写入的数据不能为空");
		//2.执行写入操作(返回值默认为写入的行数)
		int rows= equipmentDao.insertObject(entity);
		//3.对结果进行业务判定
		if(rows==-1)
			throw new ServiceException("insert error");
		
	}

	public void updateObject(Equipment entity) {
		//1.判定参数的有效性
		if(entity==null)
		throw new ServiceException("被修改的记录不能空");
		//2.执行修改操作
		int rows=equipmentDao.updateObject(entity);
		//3.根据结果判定是否修改成功
		if(rows!=1)
			throw new RuntimeException("修改失败");
		
	}

	
	


}
