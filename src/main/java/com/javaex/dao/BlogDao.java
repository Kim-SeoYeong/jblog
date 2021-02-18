package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlSession;

	//블로그 한개 조회하기
	public BlogVo userSelectOne(String id) {
		System.out.println("[userDao.blogSelectOne()]");
		
		return sqlSession.selectOne("blog.blogSelectOne", id);
	}
}
