package com.api.shadow.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.api.shadow.modal.ArticleModal;

public class ApiResponseNewsList {

	private int status;
	private String message;
	private List<ArticleModal> articleModalList;

	public ApiResponseNewsList(HttpStatus status, String message, List<ArticleModal> articleModalList) {
		this.status = status.value();
		this.message = message;
		this.articleModalList = articleModalList;
	}

	public ApiResponseNewsList(HttpStatus status, String message) {
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

	public List<ArticleModal> getArticleModalList() {
		return articleModalList;
	}

	public void setArticleModalList(List<ArticleModal> articleModalList) {
		this.articleModalList = articleModalList;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + status + ", message=" + message + "]";
	}

}
