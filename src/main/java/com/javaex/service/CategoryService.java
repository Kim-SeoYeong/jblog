package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	//카테고리 리스트 조회
	public List<CategoryVo> categoryList(String id) {
		System.out.println("[categoryService.categoryList()");
		
		return categoryDao.categoryList(id);
	}
}	
