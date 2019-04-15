package erp.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import erp.common.entity.Codelibrary;


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
public interface CodeLibraryService {
	
	List<Codelibrary> findObjects(String codeno);
	
	Codelibrary findObject(String codeno,String itemno);
	
	List<Codelibrary> findShengObjects();
	List<Codelibrary> findShiObjects(String itemno);
	List<Codelibrary> findQuObjects(String itemno);
	/**向表中写入数据*/
    void saveObject(Codelibrary entity);
    /**修改表中数据*/
    void updateObject(Codelibrary entity);
}
