package com.api.shadow.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.MailDao;
import com.api.shadow.dao.UserDao;
import com.api.shadow.entity.NotificationEntity;
import com.api.shadow.entity.UserEntity;
import com.api.shadow.modal.NotificationModal;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	MailDao mailDao;

	@Autowired
	UserDao userDao;

	@Override
	public boolean saveNotification(NotificationModal notificationModal) {
		NotificationEntity notificationEntity = new NotificationEntity();
		UserEntity userEntity = null;
		if (null != notificationModal.getNotifUserEmail()) {
			userEntity = userDao.findByUserEmail(notificationModal.getNotifUserEmail());
			if (null == userEntity) {
				return false;
			}
		} else {
			return false;
		}
		BeanUtils.copyProperties(notificationModal, notificationEntity);
		notificationEntity.setNotifUserID(userEntity.getUserID());
		notificationEntity.setNotifIsRead(VariableConstants.FLAG_N);
		notificationEntity.setNotifIsDeleted(VariableConstants.FLAG_N);
		notificationEntity.setNotifUpdatedBy("ENGINE");
		notificationEntity.setNotifCreatedDateTime(new Date());
		notificationEntity.setNotifModifiedDateTime(new Date());

		return mailDao.saveNotification(notificationEntity);
	}

	@Override
	public List<NotificationEntity> getNotificationList(String username) {
		UserEntity userEntity = null;
		List<NotificationEntity> notificationEntity = new ArrayList<NotificationEntity>();

		if (null != username) {
			userEntity = userDao.findByUsername(username);
			if (null == userEntity) {
				return notificationEntity;
			}
		} else {
			return notificationEntity;
		}

		return mailDao.getNotificationList(userEntity.getUserID());
	}

	@Override
	public int getNotificationListLength(String username) {
		UserEntity userEntity = null;

		if (null != username) {
			userEntity = userDao.findByUsername(username);
			if (null == userEntity) {
				return 0;
			}
		} else {
			return 0;
		}

		return mailDao.getNotificationList(userEntity.getUserID()).size();
	}

}
