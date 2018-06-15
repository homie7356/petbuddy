package com.pet.buddy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.buddy.domain.User;

@Repository
public class UserDao {
	//������ �ڷ����� ��ü�� ������ ����
	@Autowired
	private SqlSession sqlSession;
	
	//�����͸� ���� �о���� �޼ҵ�
	public List<User> alluser(){
		return sqlSession.selectList("user.alluser");
	}


	//email �ߺ� üũ�� ���� �޼ҵ�
	public String petemailCheck(String email) {
		//������ 1���� �޾ƿ��� sql ����
		return sqlSession.selectOne("user.petemailcheck",email);
	}
	
	//ȸ�� ������ ���� �޼ҵ�
	public void register(User user) {
		sqlSession.insert("user.register", user);
	}

	}
