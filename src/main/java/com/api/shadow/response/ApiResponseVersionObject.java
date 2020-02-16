package com.api.shadow.response;

import org.springframework.http.HttpStatus;

import com.api.shadow.modal.entity.VersionEntity;

public class ApiResponseVersionObject {

	private int status;
	private String message;
	private VersionEntity versionEntity;

	public ApiResponseVersionObject(HttpStatus status, String message, VersionEntity versionEntity) {
		this.status = status.value();
		this.message = message;
		this.versionEntity = versionEntity;
	}

	public ApiResponseVersionObject(HttpStatus status, String message) {
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

	public VersionEntity getVersionEntity() {
		return versionEntity;
	}

	public void setVersionEntity(VersionEntity versionEntity) {
		this.versionEntity = versionEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
