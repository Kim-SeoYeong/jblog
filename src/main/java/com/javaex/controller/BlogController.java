package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	//메인화면
	@RequestMapping(value="/", method={RequestMethod.GET, RequestMethod.POST})
	public String jblogMain() {
		System.out.println("/main");
		return "main/index";
	}
	
	//개인블로그 생성화면 
	@RequestMapping(value="/{id}", method={RequestMethod.GET, RequestMethod.POST})
	public String blogForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController.blogForm()]");
		
		BlogVo blogVo = blogService.blogSelectOne(id);
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		
		return "blog/blog-main";
	}
	
	//ajax로 블로그 카테고리 포스트 뿌리기
	@ResponseBody
	@RequestMapping(value="/admin/postList", method={RequestMethod.GET, RequestMethod.POST})
	public List<PostVo> postList(@RequestParam("id") String id) {
		System.out.println("[BlogController.postList()]");
		
		return postService.postList(id);
	}
	
	//내블로그 관리 화면
	@RequestMapping(value="/{id}/admin/basic", method={RequestMethod.GET, RequestMethod.POST})
	public String adminForm(@PathVariable("id") String id, Model model){
		System.out.println("[BlogController.adminForm(])");
		
		BlogVo blogVo = blogService.blogSelectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-basic";
	}
	
	//블로그 기본설정
	@RequestMapping(value="/upload", method={RequestMethod.GET, RequestMethod.POST})
	public String adminBasic(@ModelAttribute BlogVo blogVo, @RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
		System.out.println("[BlogController.adminBasic()]");
		
		blogService.profileModify(blogVo, file);
		
		return "redirect:/"+ id + "/admin/basic";
	}
	
	//카테고리 관리폼
	@RequestMapping(value="/{id}/admin/category", method={RequestMethod.GET, RequestMethod.POST})
	public String categoryForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController.categoryForm()]");
		
		BlogVo blogVo = blogService.blogSelectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-cate";

	}
	
	//카테고리 관리 리스트 뿌리기(ajax 리스트 뿌려주기위해서 만듬)
	@ResponseBody
	@RequestMapping(value="/admin/categoryList", method={RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> categoryForm(@ModelAttribute CategoryVo categoryVo) {
		System.out.println("[BlogController.categoryForm()]");
		//System.out.println(categoryVo.getId());
		//List<CategoryVo> cList = categoryService.categoryList(categoryVo.getId());
		//System.out.println(cList);
		
		return categoryService.categoryPostCnt(categoryVo.getId());
	}
	
	
	//카테고리 추가 insert
	@ResponseBody
	@RequestMapping(value="/admin/categoryAdd", method={RequestMethod.GET, RequestMethod.POST})
	public CategoryVo categoryAdd(@ModelAttribute CategoryVo categoryVo) {
		System.out.println("[BlogController.categoryAdd()]");
		CategoryVo cateVo = categoryService.categoryInsert(categoryVo);
		
		return cateVo;
	}
	
	//글작성 폼
	@RequestMapping(value="/{id}/admin/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController.writeForm()]");
		
		//블로그 헤더에 데이터들을 위해 
		BlogVo blogVo = blogService.blogSelectOne(id);
		model.addAttribute("blogVo", blogVo);
		
		//카테고리 제목을 불러오기 위해
		List<CategoryVo> categoryList = categoryService.categoryList(id);
		model.addAttribute("categoryList", categoryList);
		
		return "blog/admin/blog-admin-write";
	}
	
	//글작성
	@RequestMapping(value="/admin/blogWrite", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PostVo postVo, @RequestParam("id") String id) {
		System.out.println("[BlogController.write()]");
		
		//블로그 포스트 insert
		postService.postWrite(postVo);
		System.out.println(id);
		
		return "redirect:/" + id + "/admin/writeForm";
	}
	
}
