package com.api.shadow.dao;

import java.util.List;

import com.api.shadow.entity.NotificationEntity;

public interface MailDao {

	boolean saveNotification(NotificationEntity notificationEntity);

	List<NotificationEntity> getNotificationList(int userId);
}
