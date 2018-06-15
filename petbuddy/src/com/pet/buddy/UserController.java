package com.pet.buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pet.buddy.service.UserService;

public class UserController {
	@Autowired
	private UserService userService;
	
	//RedirectAttributes�� redirect�� �̵��� �� �ѹ��� ���޵Ǵ� �����͸�
		//�����ϴ� Spring�� Ŭ����
		public String register(MultipartHttpServletRequest request,
				RedirectAttributes attr) {
			userService.register(request);
			attr.addFlashAttribute("msg", "ȸ������");
			//����, ����, ���� �������� �����̷�Ʈ�� �̵�
			return "redirect:/";
		}
}
