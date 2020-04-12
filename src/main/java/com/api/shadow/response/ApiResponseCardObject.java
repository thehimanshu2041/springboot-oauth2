package com.api.shadow.response;

import org.springframework.http.HttpStatus;

import com.api.shadow.entity.CardEntity;

public class ApiResponseCardObject {

	private int status;
	private String message;
	private CardEntity cardEntity;

	public ApiResponseCardObject(HttpStatus status, String message, CardEntity cardEntity) {
		this.status = status.value();
		this.message = message;
		this.cardEntity = cardEntity;
	}

	public ApiResponseCardObject(HttpStatus status, String message) {
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

	public CardEntity getCardEntity() {
		return cardEntity;
	}

	public void setCardEntity(CardEntity cardEntity) {
		this.cardEntity = cardEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
