package com.newslive.actions.db.services;

import java.util.List;

import com.newslive.actions.db.dao.NewsDAO;
import com.newslive.actions.db.entity.News;

public class NewsServices{

	public void addNews(News news) throws Exception {
		NewsDAO newsDao = new NewsDAO();
		newsDao.addNews(news);
	}

	public List<News> getHeadlineList() throws Exception {
		NewsDAO newsDao = new NewsDAO();
		return newsDao.getHeadLineList();
	}

	public News getNews(long newsId) throws Exception {
		System.out.println("service : getNews");
		NewsDAO newsDao = new NewsDAO();
		News news = newsDao.getNews(newsId);
		return news;
	}
}
