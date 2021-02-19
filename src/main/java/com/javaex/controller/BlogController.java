package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
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
		
		//Map<String, Object> tMap = blogService.totalSelectOne(id);
		
		//model.addAttribute("tMap", tMap);
		
		BlogVo blogVo = blogService.blogSelectOne(id);
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		
		return "blog/blog-main";
	}
	
	//내블로그 관리 화면
	@RequestMapping(value="/{id}/admin/basic", method={RequestMethod.GET, RequestMethod.POST})
	public String adminForm(@PathVariable("id") String id, Model model){
		System.out.println("[BlogController.adminForm()");
		
		BlogVo blogVo = blogService.blogSelectOne(id);
		
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
	@RequestMapping(value="/{id}/admin/category", method={RequestMethod.GET, RequestMethod.POST})
	public String categoryForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController.categoryForm()");
		
		BlogVo blogVo = blogService.blogSelectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-cate";

	}
	
	//카테고리 관리폼2(ajax 리스트 뿌려주기위해서 만듬)
	//하나로 해보려했는데 도저히 안되네ㅠㅠㅠㅠ일단 다음부분때매 이렇게 하고 넘기자
	@ResponseBody
	@RequestMapping(value="/{id}/admin/category2", method={RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> categoryForm2(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController.categoryForm()");
		List<CategoryVo> cList = categoryService.categoryList(id);
		System.out.println(cList);
		
		return categoryService.categoryList(id);
	}
	
	
	//카테고리 추가 insert
	@ResponseBody
	@RequestMapping(value="/admin/categoryAdd", method={RequestMethod.GET, RequestMethod.POST})
	public CategoryVo categoryAdd(@ModelAttribute CategoryVo categoryVo) {
		System.out.println("[BlogController.categoryAdd()");
		CategoryVo cateVo = categoryService.categoryInsert(categoryVo);
		
		return cateVo;
	}
	
}
