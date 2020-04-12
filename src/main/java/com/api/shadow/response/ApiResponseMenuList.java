package com.api.shadow.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.api.shadow.entity.MenuEntity;

public class ApiResponseMenuList {

	private int status;
	private String message;
	private List<MenuEntity> menuEntity;

	public ApiResponseMenuList(HttpStatus status, String message, List<MenuEntity> menuEntity) {
		this.status = status.value();
		this.message = message;
		this.menuEntity = menuEntity;
	}

	public ApiResponseMenuList(HttpStatus status, String message) {
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

	public List<MenuEntity> getMenuEntity() {
		return menuEntity;
	}

	public void setMenuEntity(List<MenuEntity> menuEntity) {
		this.menuEntity = menuEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
