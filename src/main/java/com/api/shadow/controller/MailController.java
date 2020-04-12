package com.api.shadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.NotificationRepository;
import com.api.shadow.entity.NotificationEntity;
import com.api.shadow.modal.NotificationModal;
import com.api.shadow.response.ApiResponseMailBoolean;
import com.api.shadow.response.ApiResponseMailList;
import com.api.shadow.response.ApiResponseMailNumber;
import com.api.shadow.service.MailService;

@RestController
@RequestMapping("/api/mail")
public class MailController {

	public static final String SUCCESS = "success";

	@Autowired
	MailService mailService;
	@Autowired
	NotificationRepository notificationRepository;

	@RequestMapping(value = "/save-notification", method = RequestMethod.POST)
	public ApiResponseMailBoolean saveNotification(@RequestBody NotificationModal notificationModal) {
		return new ApiResponseMailBoolean(HttpStatus.OK, VariableConstants.SUCCESS,
				mailService.saveNotification(notificationModal));
	}

	@RequestMapping(value = "/get-notification-list", method = RequestMethod.GET)
	public ApiResponseMailList getNotificationList(@RequestParam(name = "username", required = true) String username) {
		return new ApiResponseMailList(HttpStatus.OK, VariableConstants.SUCCESS,
				mailService.getNotificationList(username));
	}

	@RequestMapping(value = "/get-notification-list-length", method = RequestMethod.GET)
	public ApiResponseMailNumber getNotificationListLength(
			@RequestParam(name = "username", required = true) String username) {
		return new ApiResponseMailNumber(HttpStatus.OK, VariableConstants.SUCCESS,
				mailService.getNotificationListLength(username));
	}

	@RequestMapping(value = "/delete-notification", method = RequestMethod.PUT)
	public ApiResponseMailBoolean deleteNotification(@RequestBody NotificationEntity notificationEntity) {
		notificationEntity.setNotifIsDeleted(VariableConstants.FLAG_Y);
		notificationRepository.save(notificationEntity);
		return new ApiResponseMailBoolean(HttpStatus.OK, VariableConstants.SUCCESS, true);
	}
}
