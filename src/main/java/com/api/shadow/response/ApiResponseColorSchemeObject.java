package com.api.shadow.response;

import org.springframework.http.HttpStatus;

import com.api.shadow.entity.ColorSchemeEntity;

public class ApiResponseColorSchemeObject {

	private int status;
	private String message;
	private ColorSchemeEntity colorSchemeEntity;

	public ApiResponseColorSchemeObject(HttpStatus status, String message, ColorSchemeEntity colorSchemeEntity) {
		this.status = status.value();
		this.message = message;
		this.colorSchemeEntity = colorSchemeEntity;
	}

	public ApiResponseColorSchemeObject(HttpStatus status, String message) {
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

	public ColorSchemeEntity getColorSchemeEntity() {
		return colorSchemeEntity;
	}

	public void setColorSchemeEntity(ColorSchemeEntity colorSchemeEntity) {
		this.colorSchemeEntity = colorSchemeEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
