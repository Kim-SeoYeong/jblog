package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
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
		userDao.blogInsert(blogVo);
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
