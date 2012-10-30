package com.acme.presenter.auth;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.presenter.domain.Adress;

@Controller
@RequestMapping("/auth")
public class FaceBookController implements AuthController{

	@RequestMapping(value="/facebook/login",method = RequestMethod.POST, produces = "text/html")
    public String loginFacebook() {
       System.out.println("----------------");
		return "";
	}
	
	
}
