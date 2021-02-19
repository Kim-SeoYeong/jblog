package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlSession;
	
	//post 글작성
	public void postInsert(PostVo postVo) {
		System.out.println("[postDao.postInsert()");
		
		sqlSession.insert("post.postInsert", postVo);
	}
	
}
