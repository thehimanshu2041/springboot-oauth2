package com.api.shadow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.shadow.modal.ArticleModal;
import com.api.shadow.modal.NewsModal;

@Service
@PropertySource(value = { "classpath:api.properties" })
public class NewsServiceImpl implements NewsService {

	@Autowired
	private Environment environment;

	@Override
	public List<ArticleModal> getNewsList() {
		RestTemplate restTemplate = new RestTemplate();
		NewsModal newsModal = restTemplate.getForObject(
				environment.getRequiredProperty("news.api.url") + environment.getRequiredProperty("news.api.key"),
				NewsModal.class);
		return newsModal.getArticles();
	}
}
