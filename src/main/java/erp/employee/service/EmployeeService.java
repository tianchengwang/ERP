package erp.employee.service;

import java.util.List;
import java.util.Map;

import erp.employee.entity.Employee;


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
public interface EmployeeService {
	
	//List<Employee> findObjects();
	Map<String,Object> findObjects(String name,Integer valid,int pageCurrent);
	Employee findObjectById(Integer id);
	/**向表中写入数据*/
    void saveObject(Employee entity);
    /**修改表中数据*/
    void updateObject(Employee entity);
    void validById(
   		 String idStr,
   		 Integer valid);
}
