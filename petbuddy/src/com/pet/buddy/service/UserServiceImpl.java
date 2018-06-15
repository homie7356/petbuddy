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
		//파라미터 읽기
		String email=request.getParameter("petemail");
		return userDao.petemailCheck(email);
	}

	@Override
	public void register(MultipartHttpServletRequest request) {
		//파라미터 읽기
		int petid=Integer.parseInt(request.getParameter("petid"));
		String petemail = request.getParameter("petemail");
		String petpw=request.getParameter("petpw");
		String nickname = request.getParameter("nickname");
		
		//파일은 읽는 방법이 다름
		MultipartFile image = request.getFile("image");
		//파일을 저장할 경로 만들기
		//파일은 절대경로로만 저장이 가능
		//프로젝트 내의 userimage 디렉토리의 절대 경로를 만들기
		String uploadPath = request.getRealPath("/userimage");
		//랜덤한 64자리의 문자열 만들기
		UUID uid = UUID.randomUUID();
		//원본 파일이름 가져오기
		String filename = image.getOriginalFilename();
		filename = uid + "_" + filename;
		//업로드할 파일의 실제 경로 만들기
		String filepath = uploadPath + "\\" + filename;
		
		//Dao의 파라미터로 사용할 객체
		User user = new User();
		//업로드할 파일 객체 만들기
		File f = new File(filepath);
		try{
			//파일 전송 - 파일 업로드
			image.transferTo(f);
			//Dao의 파라미터 만들기
			user.setPetemail(petemail);
			user.setPetpw(BCrypt.hashpw(petpw, BCrypt.gensalt(10)));
			user.setNickname(nickname);
			//데이터베이스에는 파일 이름만 저장
			user.setPetimg(filename);
			userDao.register(user);
		}catch(Exception e) {
			System.out.println("회원가입 실패:" + e.getMessage());
		}
		
	}

}
