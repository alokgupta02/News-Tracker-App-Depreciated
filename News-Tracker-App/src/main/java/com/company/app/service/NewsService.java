package com.company.app.service;

import java.util.List;
import java.util.Optional;

import com.company.app.entity.News;

public interface NewsService {

	//create
	public void addNews(News news);
	
	//read
	public List<News> getAllNews();
	
	//update
	public Optional<News> findNewsById(int id);
	
	//delete
	public void deleteNews(int id);
}