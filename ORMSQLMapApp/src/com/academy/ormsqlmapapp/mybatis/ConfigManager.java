package com.academy.ormsqlmapapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConfigManager {

	SqlSessionFactory sqlSessionFactory;
	private static ConfigManager instance;

	private ConfigManager() {

		try {
			String resource = "com/academy/ormsqlmapapp/mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public SqlSession getSqlSession() {

		return sqlSessionFactory.openSession();
	}
	
	public void closeSelSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		
		return instance;
	}
}
