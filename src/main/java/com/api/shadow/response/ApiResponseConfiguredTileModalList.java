package com.api.shadow.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.api.shadow.entity.ConfiguredTileEntity;

public class ApiResponseConfiguredTileModalList {

	private int status;
	private String message;
	private List<ConfiguredTileEntity> configuredTileEntities;

	public ApiResponseConfiguredTileModalList(HttpStatus status, String message,
			List<ConfiguredTileEntity> configuredTileEntities) {
		this.status = status.value();
		this.message = message;
		this.configuredTileEntities = configuredTileEntities;
	}

	public ApiResponseConfiguredTileModalList(HttpStatus status, String message) {
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

	public List<ConfiguredTileEntity> getConfiguredTileEntities() {
		return configuredTileEntities;
	}

	public void setConfiguredTileEntities(List<ConfiguredTileEntity> configuredTileEntities) {
		this.configuredTileEntities = configuredTileEntities;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
