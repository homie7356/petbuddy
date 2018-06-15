package com.pet.buddy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.buddy.domain.User;

@Repository
public class UserDao {
	//동일한 자료형의 객체가 있으면 주입
	@Autowired
	private SqlSession sqlSession;
	
	//데이터를 전부 읽어오는 메소드
	public List<User> alluser(){
		return sqlSession.selectList("user.alluser");
	}


	//email 중복 체크를 위한 메소드
	public String petemailCheck(String email) {
		//데이터 1개를 받아오는 sql 실행
		return sqlSession.selectOne("user.petemailcheck",email);
	}
	
	//회원 가입을 위한 메소드
	public void register(User user) {
		sqlSession.insert("user.register", user);
	}

	}
