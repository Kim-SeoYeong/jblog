package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PostDao postDao;
	
	//카테고리 리스트 조회
	public List<CategoryVo> categoryList(String id) {
		System.out.println("[categoryService.categoryList()");
	
		return categoryDao.categoryList(id);
	}
	
	//카테고리 포스트 수 조회
	public List<CategoryVo> categoryPostCnt(String id) {
		System.out.println("[categoryService.categoryPostCnt()");
	
		List<CategoryVo> cList = categoryDao.categoryPostList(id);
		System.out.println("카테고리 조회수 포함 리스트 : " + cList);
	
		return cList;
	}
	
	//카테고리 인서트
	public CategoryVo categoryInsert(CategoryVo categoryVo) {
		System.out.println("[categoryService.categoryInsert()");
	
		System.out.println("전 : " + categoryVo.toString());
		//카테고리를 insert
		categoryDao.insertSelectKey(categoryVo);
		
		System.out.println("후 : " + categoryVo.toString());
		
		int cateNo = categoryVo.getCateNo();
		
		return categoryDao.categorySelectOne(cateNo);
	}
}	
