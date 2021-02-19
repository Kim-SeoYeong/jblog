package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlSession;
	
	//블로그 테이블에 정보 저장
	public void blogInsert(BlogVo blogVo) {
		System.out.println("[userDao.blogInsert()]");
		
		sqlSession.insert("blog.blogInsert", blogVo);
	}

	//블로그 한개 조회하기
	public BlogVo blogSelectOne(String id) {
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
