package com.javaex.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private HttpSession session;
	
	//카테고리 리스트 조회
	public List<CategoryVo> categoryList(String id) {
		System.out.println("[categoryService.categoryList()");
		
		return categoryDao.categoryList(id);
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
