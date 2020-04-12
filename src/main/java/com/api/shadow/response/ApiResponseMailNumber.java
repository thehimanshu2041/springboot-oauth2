package com.api.shadow.response;

import org.springframework.http.HttpStatus;

public class ApiResponseMailNumber {

	private int status;
	private String message;
	private int length;

	public ApiResponseMailNumber(HttpStatus status, String message, int length) {
		this.status = status.value();
		this.message = message;
		this.length = length;
	}

	public ApiResponseMailNumber(HttpStatus status, String message) {
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
