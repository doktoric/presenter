package com.acme.presenter.auth;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.presenter.web.GithubAccount.GitHubApi;

@Controller
@RequestMapping("/auth")
public class GithubController implements AuthController {

	@RequestMapping(value = "/github/login", method = RequestMethod.GET, produces = "text/html")
	public String loginGithub(HttpServletRequest request,
			HttpServletResponse response) {

		OAuthService service = new ServiceBuilder().provider(GitHubApi.class)
				.apiKey("1bbec341e648577faabe")
				.apiSecret("68cb0e75ba753690da2c27e813e4c65df097f2be")
				.callback("http://localhost:8080/presenter/auth/github/login")
				.build();

		String code = request.getParameter("code");
		Verifier verifier = new Verifier(code);
		Token accessToken = service.getAccessToken(null, verifier);
	
		if (accessToken.getToken() == null || accessToken.getToken() == "") {
			return "login";
		} else {
			return "index";
		}
	}
}
