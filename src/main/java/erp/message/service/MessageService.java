package erp.message.service;

import java.util.Map;

import erp.message.entity.Message;



public interface MessageService {
	void insertMessage(Message message);
	Map<String,Object> findObjects(String m_type,Integer pageCurrent);
	Message findObjectById(Integer id);
	void updateObject(Message entity);
	void deleteMessageObject(Integer id);
}
