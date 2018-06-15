package com.pet.buddy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.buddy.dao.UserDao;
import com.pet.buddy.domain.User;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
	@Override
	public List<User> alluser(HttpServletRequest request) {
		
		return userDao.alluser();
	}

	@Override
	public String emailCheck(HttpServletRequest request) {
		//�Ķ���� �б�
		String email=request.getParameter("petemail");
		return userDao.emailCheck(email);
	}

}
