package erp.apply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import erp.apply.entity.Apply;
import erp.common.dao.BaseDao;



/**
 * 数据持久层对(方法名必与ProjectMapper中的id值对)
 *@author tcwang 2018/04/11 
 */
public interface ApplyDao extends BaseDao<Apply> {
	/**获得表中有记
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态(1,0)
	 * @param startIndex 表示从哪条记录开始取数据
	 * @param pageSize 表示每页显示多少条记
	 * @return 表示查询到的当前页的有记
	 * 当方法中的参数个数多1个时要使
	 * @param 注解进行声明
	 * */
	List<Apply> findObjects(@Param("id")Integer employeeid,@Param("type")String applytype,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	
	/**根据id执行查询操作
	 * @param id 来自页面上的某条记录的id
	 * */
	Apply findObjectById(@Param("applyno")Integer applyno);
	
	
	
	/**获得总记录数
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态(1,0)
	 * @return 总记录数
	 */
	int getRowCount(@Param("type")String applytype,@Param("id")Integer id);

	/**禁用或启动项目信
	 * String idStr=1,2,3;
	 * String ids[]=ids.split(",");[1,2,3];
	 * @param 要修改的id的
	 * @param 将valid具体修改为什么(1,0)
	 * @return 为被修改的记录的行数
	 * *//*
	int statusById(
			@Param("ApplyId")String ApplyId,
			@Param("status")int status);
	
	*/
	/**查询有启用项目的id以及名字*//*
	List<Map<String,Object>>
	findPrjIdAndNames();*/
}
