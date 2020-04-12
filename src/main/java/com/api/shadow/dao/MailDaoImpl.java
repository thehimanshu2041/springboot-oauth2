package com.api.shadow.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.NotificationRepository;
import com.api.shadow.entity.NotificationEntity;

@Service
public class MailDaoImpl implements MailDao {

	@Autowired
	NotificationRepository notificationRepository;

	@Override
	public boolean saveNotification(NotificationEntity notificationEntity) {
		boolean flag = false;
		try {
			notificationRepository.save(notificationEntity);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<NotificationEntity> getNotificationList(int userId) {
		return notificationRepository.getNotificationList(userId, VariableConstants.FLAG_N);
	}

}
