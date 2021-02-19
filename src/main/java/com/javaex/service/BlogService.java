package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;

	//블로그 한명 조회하기
	public BlogVo blogSelectOne(String id) {
		System.out.println("[blogService.userSelectOne()]");

		return blogDao.blogSelectOne(id);
	}
	
	//블로그 프로필 수정
	public void profileModify(BlogVo blogVo, MultipartFile file) {
		System.out.println("[blogService.profileModify()]");
		
		//DB파일 정보 수집
		//파일을 저장할 경로
		String saveDir = "c:\\javaStudy\\upload";
		System.out.println("saveDir = " + saveDir);
		
		//파일 확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName = " + exName);
		
		//서버저장 파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName = " + saveName);
		blogVo.setLogoFile(saveName);
		
		//서버 파일패스 --> 저장경로(하드디스크)
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath = " + filePath);
		
		//서버 하드에 파일 저장
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(blogVo.toString());
		
		blogDao.basicUpdate(blogVo);
		
	}
}
