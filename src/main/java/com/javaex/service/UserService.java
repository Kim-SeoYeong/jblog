package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PostDao postDao;
	
	//회원가입
	public void join(UserVo userVo) {
		System.out.println("[userService.join()]");
		
		userDao.userInsert(userVo);
		//System.out.println(userVo.getId());
		//System.out.println(userVo.getUserName());
		
		//회원가입 insert 후 blog 테이블에 정보 insert 해주기
		String id = userVo.getId();		//blog 테이블 id
		String blogTitle = userVo.getUserName() + "의 블로그 입니다.";	//블로그제목
		//blogVo에 넣어주자
		BlogVo blogVo = new BlogVo(id, blogTitle, null);
		blogDao.blogInsert(blogVo);
		
		//categoryVo에 넣어주자(기본적으로 미분류가 들어가야함)
		CategoryVo categoryVo = new CategoryVo(id, "미분류", "기본으로 만들어지는 카테고리 입니다");
		categoryDao.insertSelectKey(categoryVo);
			
		//System.out.println(categoryVo);
		
		//postVo에 초기값 세팅
		int cateNo = categoryVo.getCateNo();
		String postContent = "";
		//System.out.println(cateNo);
		PostVo postVo = new PostVo(cateNo, "등록된 글이 없습니다.", postContent);
		postDao.postInsert(postVo);
	}
	
	//아이디체크
	public String checkId(String id) {
		System.out.println("[userService.checkId()]");
		
		UserVo userVo = userDao.idSelectOne(id);
		
		String result = "";
		
		if(userVo == null) {
			result = "can";
		} else {
			result = "cant";
		}
		
		return result;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("[userService.login()]");
		
		return userDao.selectUser(userVo);
	}
	
}
