package com.api.shadow.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.api.shadow.entity.country.CountryEntity;

public class ApiResponseCountryList {

	private int status;
	private String message;
	private List<CountryEntity> countryEntity;

	public ApiResponseCountryList(HttpStatus status, String message, List<CountryEntity> countryEntity) {
		this.status = status.value();
		this.message = message;
		this.countryEntity = countryEntity;
	}

	public ApiResponseCountryList(HttpStatus status, String message) {
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

	public List<CountryEntity> getCountryEntity() {
		return countryEntity;
	}

	public void setCountryEntity(List<CountryEntity> countryEntity) {
		this.countryEntity = countryEntity;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
