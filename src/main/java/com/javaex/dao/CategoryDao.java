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

	//글저장(selectKey)
	public void insertSelectKey(CategoryVo categoryVo) {
		System.out.println("[categoryDao.insertSelectKey()]");
		
		//System.out.println("xml 실행전 ==> " + categoryVo);
		sqlSession.insert("category.insertSelectKey", categoryVo);
		//System.out.println("xml 실행후 ==> " + categoryVo);
	}
	
	//카테고리 목록 조회
	public List<CategoryVo> categoryList(String id) {
		System.out.println("[categoryDao.categorySelect()]");

		return sqlSession.selectList("category.categoryList", id);
	}
	
	//카테고리 목록 조회수 포함 조회
	public List<CategoryVo> categoryPostList(String id) {
		System.out.println("[categoryDao.categoryPostList()]");

		return sqlSession.selectList("category.categoryPostList", id);
	}
	
	//카테고리 1개 조회
	public CategoryVo categorySelectOne(int cateNo) {
		System.out.println("[categoryDao.categorySelectOne()]");

		return sqlSession.selectOne("category.cateSelectOne", cateNo);
	}
	
	//카테고리 삭제
	public int categoryDelete(int cateNo) {
		System.out.println("[categoryDao.categoryDelete()]");
		
		return sqlSession.delete("category.categoryDelete", cateNo);
	}

}
