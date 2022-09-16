package com.academy.springdb.model.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.springdb.exception.NewsException;
import com.academy.springdb.model.domain.News;

@Service
public class NewsServicreImpl implements NewsService {

	@Autowired
	@Qualifier("mybatisNewsDAO")
	private NewsDAO newsDAO;

	@Autowired
	@Qualifier("mybatisCommentsDAO")
	private CommentsDAO commentsDAO;

	@Override
	public List selectAll() {

		return newsDAO.selectAll();
	}

	@Override
	public News select(int news_id) {

		return newsDAO.select(news_id);
	}

	@Override
	public void regist(News news) throws NewsException {
		newsDAO.insert(news);

	}

	@Override
	public void update(News news) {
		newsDAO.update(news);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int news_id) {

		// 세부업무1 딸려있는 댓글 삭제   댓글 먼저 지우고 글을 지우도록 순서를 바꾼다.
		commentsDAO.deleteByNewsId(news_id);
		
		// 세부업무 2 - 부모글 삭제
		newsDAO.delete(news_id);

	}

}
