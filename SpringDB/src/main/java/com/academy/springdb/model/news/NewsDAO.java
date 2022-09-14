package com.academy.springdb.model.news;

import java.util.List;

import com.academy.springdb.model.domain.News;

public interface NewsDAO {
	public List selectAll();		// 모두 가져오기
	
	public News select(int news_id);	// 한 건 가져오기
	public void insert(News news);
	public void update(News news);
	public void delete(int news_id);
	
}
