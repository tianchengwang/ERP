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
			throw new ServiceException("������Ϣʧ�ܣ�");
	}

	public Map<String, Object> findObjects(String m_type,Integer pageCurrent) {
		Map<String,Object> map = new HashMap<String, Object>();
		// 1.��֤��������Ч��
		if (pageCurrent == null || pageCurrent < 1)
			throw new ServiceException("����ֵ��Ч,pageCurrent=" + pageCurrent);
		// 2.��ȡ��ǰҳ����
		// 2.1 ����startIndex��ֵ
		int pageSize = 9;
		int startIndex = (pageCurrent - 1) * pageSize;
		// 2.2 ����startIndex��ֵ��ȡ��ǰҳ����
		List<Message> list = messageDao.findObjects(m_type,startIndex,pageSize);
		// 3.��ȡ�ܼ�¼��(���ݴ�ֵ������ҳ��)
		int rowCount = messageDao.getRowCount(m_type);
		PageObject pageObject = new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);// ��ѡ
		// 4.��װ��ѯ�ͼ�������map����
		// 1)HashMap�ײ�ṹ?(����+����+�����)-->JDK1.8
		// 2)HashMap�Ƿ��̰߳�ȫ?(����ȫ,���̲߳�������)
		// 3)HashMap�Ƿ��ܱ�֤���Ԫ�ص�������(����,
		// ����ϣ����֤�����Կ���ѡ��LinkedHashMap)?
		// 4)HashMap�ڲ������������ʹ��?(����ת��Ϊͬ�����ϻ���
		// ֱ��ʹ��ConcurrentHashMap)
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}

	public Message findObjectById(Integer id) {
		// 1.��֤id����Ч��
		if (id == null || id < 1)
			throw new ServiceException("id��ֵ��Ч");
		// 2.����id��������
		Message message = messageDao.findObjectById(id);
		// 3.��֤����Ƿ���ȷ
		if (message == null)
			throw new ServiceException("�˼�¼�Ѿ�������");
		return message;
	}

	public void updateObject(Message entity) {
		if (entity == null)
			throw new ServiceException("�������ݲ���Ϊ��");
		Integer m_id = entity.getM_id();
		Message message = messageDao.findObjectById(m_id);
		message.setM_answer(entity.getM_answer());
		message.setRemark(entity.getRemark());
		message.setModifiedTime(DateUtil.getToday());
		message.setModifiedUser(entity.getModifiedUser());
		int rows = messageDao.updateObject(message);
		if (rows <= 0)
			throw new ServiceException("����ʧ��");
		
	}
	
	public void deleteMessageObject(Integer id) {
		// 1.��֤id����Ч��
		if (id == null || id < 1)
			throw new ServiceException("id��ֵ��Ч");
		// 2.����id��������
		int res = messageDao.deleteObject(id);
		// 3.��֤����Ƿ���ȷ
		if (res == -1)
			throw new ServiceException("�˼�¼�Ѿ�������");
	}
	
}
