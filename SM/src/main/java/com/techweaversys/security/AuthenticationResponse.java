package com.techweaversys.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1522040855800769376L;
	
	private Long id;
	private String authToken;
    private String name;
    public Collection<? extends GrantedAuthority> authorities;
    

	public AuthenticationResponse(String authToken, Long id, String name, Collection<? extends GrantedAuthority> authorities) {
        this.authToken = authToken;
        this.id = id;
		this.name = name;
		this.authorities = authorities;
		
    }
	

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	
	
	
}