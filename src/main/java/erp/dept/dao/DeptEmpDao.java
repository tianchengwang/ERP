package erp.dept.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import erp.common.dao.BaseDao;
import erp.dept.entity.DeptEmp;


/**
 * 数据持久层对(方法名必与ProjectMapper中的id值对)
 *@author tcwang 2018/04/11 
 */
public interface DeptEmpDao extends BaseDao<DeptEmp> {
	/**获得表中有记
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态(1,0)
	 * @param startIndex 表示从哪条记录开始取数据
	 * @param pageSize 表示每页显示多少条记
	 * @return 表示查询到的当前页的有记
	 * 当方法中的参数个数多1个时要使
	 * @param 注解进行声明
	 * */
	List<DeptEmp> findObjects(@Param("deptno")Integer deptno,@Param("e_id")Integer e_id,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	
	/**根据id执行查询操作
	 * @param id 来自页面上的某条记录的id
	 * */
	DeptEmp findObjectById(@Param("id")Integer id);
	
	DeptEmp findObjectByEId(@Param("e_id")Integer e_id);
	
	/**获得总记录数
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态(1,0)
	 * @return 总记录数
	 */
	int getRowCount(@Param("deptno")Integer deptno,@Param("e_id")Integer e_id);

	int deleteObject(@Param("id")Integer id);
}
