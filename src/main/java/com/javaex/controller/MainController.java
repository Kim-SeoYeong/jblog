package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class MainController {
	
	@Autowired
	private BlogService blogService;
	
	//메인화면
	@RequestMapping(value="/", method={RequestMethod.GET, RequestMethod.POST})
	public String jblogMain() {
		System.out.println("/main");
		return "main/index";
	}
	
	//개인블로그 생성화면 
	@RequestMapping(value="/{id}", method={RequestMethod.GET, RequestMethod.POST})
	public String blogForm(@PathVariable("id") String id, Model model) {
		System.out.println("[MainController.blogForm()");
		
		BlogVo blogVo = blogService.userSelectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/blog-main";
	}
	
	
}
