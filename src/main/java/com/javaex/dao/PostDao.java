package com.javaex.dao;

import java.util.List;

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
		System.out.println("[postDao.postInsert()]");
		
		sqlSession.insert("post.postInsert", postVo);
	}
	
	//카테고리 포스트 갯수 조회
	public int postCountSelect(int cateNo) {
		System.out.println("[postDao.postCountSelect()]");
			
		return sqlSession.selectOne("post.postCountSelect", cateNo);
	}
	
	//해당카테고리에 맞는 포스트 조회하기
	public List<PostVo> postList(int cateNo) {
		System.out.println("[postDao.postList()]");
		
		return sqlSession.selectList("post.postList", cateNo);
	}
	
	//포스트 1개 조회하기
	public PostVo postSelect(int postNo) {
		System.out.println("[postDao.postSelect()]");
		
		return sqlSession.selectOne("post.postSelect", postNo);
	}
}
