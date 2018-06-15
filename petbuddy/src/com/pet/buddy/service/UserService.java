package com.pet.buddy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pet.buddy.domain.User;

public interface UserService {
 public List<User> alluser(HttpServletRequest request);
	 

//email �ߺ� üũ�� ���� �޼ҵ�
//�Ķ���ʹ� 3���� 
//�Ķ���� ������ �Ķ���ͷ� ����� ��� : @RequestParam
//�Ķ���͸� ���� ��Ƽ� ����� ���: Command ��ü
//��� ��쿡 ������ �Ķ���͸� ���: HttpServletRequest
//���� ���ε尡 �ִ� ��쿡�� HttpServletRequest ��ſ�
//MultipartHttpServletRequest�� ����
public String petemailCheck(HttpServletRequest request);

//ȸ�������� ���� �޼ҵ�
//������ ���� ���� HttpServletRequest ��ſ� MultipartHttpServletRequest�� ���
public void register(MultipartHttpServletRequest request);

}


