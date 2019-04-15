package erp.dept.service;

import java.util.Map;

import erp.dept.entity.Dept;


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
public interface DeptService {
	
	//List<Project> findObjects();
	Map<String,Object> findObjects(String name);
	Dept findObjectById(Integer id);
	/**向表中写入数据*/
    void saveObject(Dept entity);
    /**修改表中数据*/
    void updateObject(Dept entity);
	
}
