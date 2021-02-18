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
		System.out.println("[BlogDao.blogSelectOne()]");
		
		return sqlSession.selectOne("blog.blogSelectOne", id);
	}
	
	//블로그 기본설정 update
	public void basicUpdate(BlogVo blogVo) {
		System.out.println("[BlogDao.basicUpdate()]");
		
		System.out.println(blogVo);
		sqlSession.update("blog.basicUpdate", blogVo);
	}
}
