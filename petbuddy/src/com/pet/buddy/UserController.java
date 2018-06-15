package com.pet.buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pet.buddy.service.UserService;

public class UserController {
	@Autowired
	private UserService userService;
	
	//RedirectAttributes는 redirect로 이동할 때 한번만 전달되는 데이터를
		//보관하는 Spring의 클래스
		public String register(MultipartHttpServletRequest request,
				RedirectAttributes attr) {
			userService.register(request);
			attr.addFlashAttribute("msg", "회원가입");
			//삽입, 삭제, 갱신 다음에는 리다이렉트로 이동
			return "redirect:/";
		}
}
