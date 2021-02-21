package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	
	//포스트 글쓰기
	public void postWrite(PostVo postVo) {
		System.out.println("[postService.postWrite()]");
		
		postDao.postInsert(postVo);
	}
	
	public List<PostVo> postList(String id) {
		System.out.println("[postService.postList()]");
		
		return postDao.postList(id);
	}
}
