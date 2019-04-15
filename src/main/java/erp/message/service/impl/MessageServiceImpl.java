package erp.message.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.common.exception.ServiceException;
import erp.common.util.DateUtil;
import erp.common.web.PageObject;
import erp.message.dao.MessageDao;
import erp.message.entity.Message;
import erp.message.service.MessageService;



@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;

	public void insertMessage(Message message) {
		String today = DateUtil.getToday();
		message.setCreatedTime(today);
		int i = messageDao.insertObject(message);
		if(i==-1)
			throw new ServiceException("保存信息失败！");
	}

	public Map<String, Object> findObjects(String m_type,Integer pageCurrent) {
		Map<String,Object> map = new HashMap<String, Object>();
		// 1.验证参数的有效性
		if (pageCurrent == null || pageCurrent < 1)
			throw new ServiceException("参数值无效,pageCurrent=" + pageCurrent);
		// 2.获取当前页数据
		// 2.1 计算startIndex的值
		int pageSize = 9;
		int startIndex = (pageCurrent - 1) * pageSize;
		// 2.2 根据startIndex的值获取当前页数据
		List<Message> list = messageDao.findObjects(m_type,startIndex,pageSize);
		// 3.获取总记录数(根据此值计算总页数)
		int rowCount = messageDao.getRowCount(m_type);
		PageObject pageObject = new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);// 可选
		// 4.封装查询和计算结果到map对象
		// 1)HashMap底层结构?(数组+链表+红黑树)-->JDK1.8
		// 2)HashMap是否线程安全?(不安全,多线程并发访问)
		// 3)HashMap是否能保证添加元素的有序性(不能,
		// 假如希望保证有序性可以选择LinkedHashMap)?
		// 4)HashMap在并发场景下如何使用?(将其转换为同步集合或者
		// 直接使用ConcurrentHashMap)
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}

	public Message findObjectById(Integer id) {
		// 1.验证id的有效性
		if (id == null || id < 1)
			throw new ServiceException("id的值无效");
		// 2.根据id查找数据
		Message message = messageDao.findObjectById(id);
		// 3.验证结果是否正确
		if (message == null)
			throw new ServiceException("此记录已经不存在");
		return message;
	}

	public void updateObject(Message entity) {
		if (entity == null)
			throw new ServiceException("更新数据不能为空");
		Integer m_id = entity.getM_id();
		Message message = messageDao.findObjectById(m_id);
		message.setM_answer(entity.getM_answer());
		message.setRemark(entity.getRemark());
		message.setModifiedTime(DateUtil.getToday());
		message.setModifiedUser(entity.getModifiedUser());
		int rows = messageDao.updateObject(message);
		if (rows <= 0)
			throw new ServiceException("更新失败");
		
	}
	
	public void deleteMessageObject(Integer id) {
		// 1.验证id的有效性
		if (id == null || id < 1)
			throw new ServiceException("id的值无效");
		// 2.根据id查找数据
		int res = messageDao.deleteObject(id);
		// 3.验证结果是否正确
		if (res == -1)
			throw new ServiceException("此记录已经不存在");
	}
	
}
