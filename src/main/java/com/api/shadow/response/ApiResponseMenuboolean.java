package com.api.shadow.response;

import org.springframework.http.HttpStatus;

public class ApiResponseMenuboolean {

	private int status;
	private String message;
	private boolean response;

	public ApiResponseMenuboolean(HttpStatus status, String message, boolean response) {
		this.status = status.value();
		this.message = message;
		this.response = response;
	}

	public ApiResponseMenuboolean(HttpStatus status, String message) {
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

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
