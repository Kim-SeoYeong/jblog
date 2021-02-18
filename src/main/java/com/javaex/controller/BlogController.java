package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {
	
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
		System.out.println("[BlogController.blogForm()");
		
		BlogVo blogVo = blogService.userSelectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/blog-main";
	}
	
	//내블로그 관리 화면
	@RequestMapping(value="/{id}/admin/basic", method={RequestMethod.GET, RequestMethod.POST})
	public String adminForm(@PathVariable("id") String id, Model model){
		System.out.println("[BlogController.adminForm()");
		BlogVo blogVo = blogService.userSelectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-basic";
	}
	
	//블로그 기본설정
	@RequestMapping(value="/upload", method={RequestMethod.GET, RequestMethod.POST})
	public String adminBasic(@ModelAttribute BlogVo blogVo, @RequestParam("file") MultipartFile file) {
		
		blogService.profileModify(blogVo, file);
		
		return "redirect:/"+ blogVo.getId() + "/admin/basic";
	}
	
	//카테고리 관리폼
	@RequestMapping
	public String categoryForm() {
		System.out.println("[BlogController.categoryForm()");
	}
	
	
}
