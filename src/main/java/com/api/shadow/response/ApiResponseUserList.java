package com.api.shadow.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.api.shadow.modal.entity.UserEntity;

public class ApiResponseUserList {

	private int status;
	private String message;
	private List<UserEntity> userEntity;

	public ApiResponseUserList(HttpStatus status, String message, List<UserEntity> userEntity) {
		this.status = status.value();
		this.message = message;
		this.userEntity = userEntity;
	}

	public ApiResponseUserList(HttpStatus status, String message) {
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

	public List<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(List<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
