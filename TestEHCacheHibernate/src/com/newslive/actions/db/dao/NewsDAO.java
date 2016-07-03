package com.newslive.actions.db.dao;

import java.util.List;

import org.hibernate.Session;

import com.newslive.actions.db.entity.News;

public class NewsDAO extends BaseDao {

	public void addNews(News news) throws Exception {
		Session session = super.getCurrentSession();
		session.beginTransaction();
		session.save(news);
		session.getTransaction().commit();
		//no need as we are working on thread base session 
		//session.close();
	}
	
	public List<News> getHeadLineList()  {
		Session session = super.getCurrentSession();
		session.beginTransaction();
		List<News> newsList = (List<News>)session.createQuery("from News").list();
		session.getTransaction().commit();
		//no need as we are working on thread base session 
		//session.close();
		return newsList;
		
	}
	
	public News getNews(long newsId) throws Exception {
		System.out.println("dao : getNews");
		Session session = super.openSession();
		session.beginTransaction();
		News news = (News) session.load(News.class, newsId);
		session.getTransaction().commit();
		System.out.println(news);
		session.close();
		return news;
	}
}
