package erp.message.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import erp.common.dao.BaseDao;
import erp.message.entity.Message;


public interface MessageDao extends BaseDao<Message> {
	int getRowCount(@Param("type")String type);
	List<Message> findObjects(@Param("type")String type,@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	Message findObjectById(@Param("id")Integer id);
	int deleteObject(@Param("id")Integer id);
	
	
}
