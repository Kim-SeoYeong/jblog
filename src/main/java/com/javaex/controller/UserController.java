package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//회원가입 폼
	@RequestMapping(value="/joinForm", method={RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("[UserController.joinForm()]");
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value="/join", method={RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("[UserController.join()]");
		
		userService.join(userVo);
		
		return "user/joinSuccess";
	}
	
	//회원가입 아이디 체크
	@ResponseBody
	@RequestMapping(value="/idcheck", method={RequestMethod.GET, RequestMethod.POST})
	public String checkId(@RequestParam("id") String id) {
		System.out.println("[UserController.checkId()]");
		
		String result = userService.checkId(id);
		System.out.println(result);
		
		return result;
	}
	
	//로그인폼
	@RequestMapping(value="/loginForm", method={RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("[UserController.loginForm()]");
		return "user/loginForm";
	}
	
	
	
	
}
