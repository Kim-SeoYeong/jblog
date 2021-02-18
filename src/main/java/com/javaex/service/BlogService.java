package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;

	//블로그 한명 조회하기
	public BlogVo userSelectOne(String id) {
		System.out.println("[userService.userSelectOne()]");
		
		return blogDao.userSelectOne(id);
	}
}
