package com.acme.presenter.auth;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.acme.presenter.domain.PresenterUser;

public class FacebookAuthenticationToken extends AbstractAuthenticationToken{

	private PresenterUser person;
	   public FacebookAuthenticationToken(Collection<? extends GrantedAuthority> authorities, PresenterUser person) {
	    super(authorities);
	    this.person = person;
	}
	public Object getCredentials() {
	    return person;
	}
	public Object getPrincipal() {
	    return this.person;
	} /* +  Person getter and setter */

}
