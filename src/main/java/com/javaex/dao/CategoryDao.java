package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	/*
	//카테고리 insert문
	public void categoryInsert(CategoryVo categoryVo) {
		System.out.println("[categoryDao.categoryInsert()");
		
		sqlSession.insert("category.categoryInsert", categoryVo);
	}
	*/
	//글저장(selectKey)
	public void insertSelectKey(CategoryVo categoryVo) {
		System.out.println("[categoryVo] insertSelectKey()");
		
		//System.out.println("xml 실행전 ==> " + categoryVo);
		sqlSession.insert("category.insertSelectKey", categoryVo);
		//System.out.println("xml 실행후 ==> " + categoryVo);
	}
	
	//카테고리 조회
	public List<CategoryVo> categoryList(String id) {
		System.out.println("[categoryDao.categorySelect()");

		return sqlSession.selectList("category.categoryList", id);
	}
}
