package erp.dept.service;

import java.util.Map;

import erp.dept.entity.DeptEmp;


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
public interface DeptEmpService {
	
	//List<Project> findObjects();
	Map<String,Object> findObjects(Integer e_id,Integer deptno,Integer pageCurrent);
	DeptEmp findObjectById(Integer id);
	DeptEmp findObjectByEId(Integer e_id);
	/**向表中写入数据*/
    void saveObject(DeptEmp entity);
    /**修改表中数据*/
    void updateObject(DeptEmp entity);
    /**删除表中数据*/
    void deleteObject(Integer id);
    
	
}
