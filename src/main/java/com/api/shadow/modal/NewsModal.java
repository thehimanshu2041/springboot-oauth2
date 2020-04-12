package com.api.shadow.modal;

import java.io.Serializable;
import java.util.List;

public class NewsModal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String status;
	private int totalResults;
	public List<ArticleModal> articles;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<ArticleModal> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleModal> articles) {
		this.articles = articles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
