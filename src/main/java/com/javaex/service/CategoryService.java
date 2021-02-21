package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PostDao postDao;
	
	//블로그 메인화면 전체 데이터 조회
	public Map<String, Object> blogTotalList(String id, int cateNo, int postNo) {
		System.out.println("[categoryService.blogTotalList()]");
		
		Map<String, Object> tMap = new HashMap<String, Object>();
		
		//카테고리 리스트를 가져오자
		List<CategoryVo> categoryList = categoryDao.categoryList(id);
		//System.out.println(categoryList);
		
		//카테고리를 클릭하지 않은 상태
		if(cateNo == 0) {	//cateNo가 기본값일때 젤 최근 카테고리의 값을 가져오자
			cateNo = categoryList.get(0).getCateNo();
			//System.out.println("cateNo : " + cateNo);
		}
		
		//해당 카테고리에 연결된 포스트 리스트
		List<PostVo> postList = postDao.postList(cateNo);
		//System.out.println("postList : " + postList);
		
		if(postList.size() != 0) {
			//postNo가 클릭되지 않은 상태일때(기본값)
			if(postNo == 0) {	
				postNo = postList.get(0).getPostNo();
				//System.out.println("1. postNo: " + postNo);
			}
		}
		
		//System.out.println("2. postNo: " + postNo);
		
		PostVo postVo = postDao.postSelect(postNo);
		//System.out.println(postVo);
		
		tMap.put("categoryList", categoryList);
		tMap.put("postList", postList);
		tMap.put("postVo", postVo);
		
		return tMap;
	}
	
	//카테고리 리스트 조회
	public List<CategoryVo> categoryList(String id) {
		System.out.println("[categoryService.categoryList()]");
	
		return categoryDao.categoryList(id);
	}
	
	//카테고리 포스트 수 조회
	public List<CategoryVo> categoryPostCnt(String id) {
		System.out.println("[categoryService.categoryPostCnt()]");
	
		List<CategoryVo> cList = categoryDao.categoryPostList(id);
		System.out.println("카테고리 조회수 포함 리스트 : " + cList);
	
		return cList;
	}
	
	//카테고리 인서트
	public CategoryVo categoryInsert(CategoryVo categoryVo) {
		System.out.println("[categoryService.categoryInsert()]");
	
		System.out.println("전 : " + categoryVo.toString());
		//카테고리를 insert
		categoryDao.insertSelectKey(categoryVo);
		
		System.out.println("후 : " + categoryVo.toString());
		
		int cateNo = categoryVo.getCateNo();
		
		return categoryDao.categorySelectOne(cateNo);
	}
	
	//카테고리 삭제
	public int deleteCategory(int cateNo) {
		System.out.println("[categoryService.deleteCategory()]");
		
		return categoryDao.categoryDelete(cateNo);
	}
}	
