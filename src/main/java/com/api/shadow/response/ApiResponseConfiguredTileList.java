package com.api.shadow.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.api.shadow.modal.ManagedContent;

public class ApiResponseConfiguredTileList {

	private int status;
	private String message;
	private List<ManagedContent> data;

	public ApiResponseConfiguredTileList(HttpStatus status, String message, List<ManagedContent> data) {
		this.status = status.value();
		this.message = message;
		this.data = data;
	}

	public ApiResponseConfiguredTileList(HttpStatus status, String message) {
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

	public List<ManagedContent> getData() {
		return data;
	}

	public void setData(List<ManagedContent> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
