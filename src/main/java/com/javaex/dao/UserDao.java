package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 정보 저장
	public void userInsert(UserVo userVo) {
		System.out.println("[userDao.userInsert()]");
		
		sqlSession.insert("user.userInsert", userVo);
	}

	//아이디 체크를위해 한명 조회
	public UserVo idSelectOne(String id) {
		System.out.println("[userDao.idSelectOne()]");
		//System.out.println(id);
		return sqlSession.selectOne("user.selectById", id);
	}
	
	//로그인을 위해 회원정보 조회
	public UserVo selectUser(UserVo userVo) {
		System.out.println("[userDao.selectUser()]");
		//System.out.println(userVo);
		return sqlSession.selectOne("user.selectUser", userVo);
	}
	
}
