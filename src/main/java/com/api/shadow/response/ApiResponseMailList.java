package com.api.shadow.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.api.shadow.entity.NotificationEntity;

public class ApiResponseMailList {

	private int status;
	private String message;
	private List<NotificationEntity> notificationEntity;

	public ApiResponseMailList(HttpStatus status, String message, List<NotificationEntity> notificationEntity) {
		this.status = status.value();
		this.message = message;
		this.notificationEntity = notificationEntity;
	}

	public ApiResponseMailList(HttpStatus status, String message) {
		this.status = status.value();
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<NotificationEntity> getNotificationEntity() {
		return notificationEntity;
	}

	public void setNotificationEntity(List<NotificationEntity> notificationEntity) {
		this.notificationEntity = notificationEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
