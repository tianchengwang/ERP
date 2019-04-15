package erp.system.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import erp.common.dao.BaseDao;
import erp.system.entity.Role;

public interface RoleDao extends BaseDao<Role> {
	/**获取�??有角色信�??*/
	List<Map<String, Object>> findObjects();
	/**分页获取�??有角色信�??*/
	List<Role> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	/**根据id获取角色信息*/
	Role findObjectById(Integer id);
	/**根据参数获取名字记录�??*/
	public int getRowCounts(@Param("name") String name);
	/**根据id删除对象信息*/
	int deleteObject(Integer id);

}
