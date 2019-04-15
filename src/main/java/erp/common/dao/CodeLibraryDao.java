package erp.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import erp.common.dao.BaseDao;
import erp.common.entity.Codelibrary;

/**
 * 数据持久层对(方法名必与ProjectMapper中的id值对)
 *@author tcwang 2018/04/11 
 */
public interface CodeLibraryDao extends BaseDao<Codelibrary> {
	
	List<Codelibrary> findObjects(@Param("codeno")String codeno);
	
	Codelibrary findObject(@Param("codeno")String codeno,@Param("itemno")String itemno);
	
	List<Codelibrary> findShengObjects();
	List<Codelibrary> findShiObjects(@Param("itemno")String itemno);
	List<Codelibrary> findQuObjects(@Param("itemno")String itemno);
	
}
