package com.pet.buddy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pet.buddy.service.UserService;

@RestController
public class JSONController {
	@Autowired
	private UserService userService;
	
	//�̸��� �ߺ� üũ ��û�� ó��
	@RequestMapping(value="user/emailcheck", 
		method=RequestMethod.GET)
	public Map<String, Object> emailCheck(
			HttpServletRequest request){
		//�����ϴ� �̸����̸� email�� �� �̸����� ����ǰ�
		//�������� �ʴ� �̸����̸� null�� ����˴ϴ�.
		String email = userService.emailCheck(request);
		
		//������ Map�� ����
		Map<String, Object> map = 
			new HashMap<String, Object>();
		//result��� Ű���� email�� null���� ���� ����
		//�����ϴ� �̸����̸� false �������� �ʴ� �̸����̸� true
		map.put("result", email == null);
		
		return map;
	}
}


