package com.api.shadow.service;

import java.util.List;

import com.api.shadow.entity.NotificationEntity;
import com.api.shadow.modal.NotificationModal;

public interface MailService {

	boolean saveNotification(NotificationModal notificationModal);

	List<NotificationEntity> getNotificationList(String username);

	int getNotificationListLength(String username);
}
