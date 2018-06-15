package com.pet.buddy.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String petemailCheck(HttpServletRequest request) {
		//�Ķ���� �б�
		String email=request.getParameter("petemail");
		return userDao.petemailCheck(email);
	}

	@Override
	public void register(MultipartHttpServletRequest request) {
		//�Ķ���� �б�
		int petid=Integer.parseInt(request.getParameter("petid"));
		String petemail = request.getParameter("petemail");
		String petpw=request.getParameter("petpw");
		String nickname = request.getParameter("nickname");
		
		//������ �д� ����� �ٸ�
		MultipartFile image = request.getFile("image");
		//������ ������ ��� �����
		//������ �����ηθ� ������ ����
		//������Ʈ ���� userimage ���丮�� ���� ��θ� �����
		String uploadPath = request.getRealPath("/userimage");
		//������ 64�ڸ��� ���ڿ� �����
		UUID uid = UUID.randomUUID();
		//���� �����̸� ��������
		String filename = image.getOriginalFilename();
		filename = uid + "_" + filename;
		//���ε��� ������ ���� ��� �����
		String filepath = uploadPath + "\\" + filename;
		
		//Dao�� �Ķ���ͷ� ����� ��ü
		User user = new User();
		//���ε��� ���� ��ü �����
		File f = new File(filepath);
		try{
			//���� ���� - ���� ���ε�
			image.transferTo(f);
			//Dao�� �Ķ���� �����
			user.setPetemail(petemail);
			user.setPetpw(BCrypt.hashpw(petpw, BCrypt.gensalt(10)));
			user.setNickname(nickname);
			//�����ͺ��̽����� ���� �̸��� ����
			user.setPetimg(filename);
			userDao.register(user);
		}catch(Exception e) {
			System.out.println("ȸ������ ����:" + e.getMessage());
		}
		
	}

}
