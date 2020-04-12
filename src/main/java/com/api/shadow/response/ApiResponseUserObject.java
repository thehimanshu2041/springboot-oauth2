package com.api.shadow.response;

import org.springframework.http.HttpStatus;

import com.api.shadow.entity.UserEntity;

public class ApiResponseUserObject {

	private int status;
	private String message;
	private UserEntity userEntity;

	public ApiResponseUserObject(HttpStatus status, String message, UserEntity userEntity) {
		this.status = status.value();
		this.message = message;
		this.userEntity = userEntity;
	}

	public ApiResponseUserObject(HttpStatus status, String message) {
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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
