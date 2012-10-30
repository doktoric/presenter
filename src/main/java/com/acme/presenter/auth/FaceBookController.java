package com.acme.presenter.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class FaceBookController implements AuthController{

	@RequestMapping(value="/facebook/login",method = RequestMethod.GET, produces = "text/html")
    public String loginFacebook(HttpServletRequest request) {
		

		return "redirect:";
	}
	
	@RequestMapping(value="/github/login",method = RequestMethod.GET, produces = "text/html")
    public String loginGithub(HttpServletRequest request) {
		
		
		System.out.println("pinaaaaa");

		return "redirect:";
	}
	
	
}
