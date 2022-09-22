package com.company.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.entity.News;
import com.company.app.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public void addNews(News news) {
		this.newsRepository.save(news);
	}

	@Override
	public List<News> getAllNews() {
		return newsRepository.findAll();
	}

	@Override
	public Optional<News> findNewsById(int id) {
		return newsRepository.findById(id);
	}

	@Override
	public void deleteNews(int id) {
		this.newsRepository.deleteById(id);
	}
}
