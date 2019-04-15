package erp.equipment.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import erp.apply.entity.Apply;
import erp.equipment.entity.Equipment;





/**
 * 业务层接口对象（负责业务的处理）
 * 1）业务逻辑的验证
 * 2）事务的处理
 * 3）日志的处理
 * 4）缓存的处理
 * 5）权限的处理
 * 6）............
 * @author soft01
 *
 */
public interface EquipmentService {
	
	//List<Project> findObjects();
	Map<String,Object> findObjects(Integer employeeid,int pageCurrent);
	Equipment findObjectById(Integer id);
	/**向表中写入数据*/
    void saveObject(Apply entity);
    
    
    /**修改表中数据*/
    void updateObject(Equipment entity);
	
}
