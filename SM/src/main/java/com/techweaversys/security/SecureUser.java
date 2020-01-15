package com.techweaversys.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SecureUser implements UserDetails {

	private static final long serialVersionUID = -1372611514076026674L;

	private Long id;
	private String username;
	private String password;
	private String name;
	private Collection<? extends GrantedAuthority> authorities;
	private Boolean accountNonExpired = true;
	private Boolean accountNonLocked = true;
	private Boolean credentialsNonExpired = true;
	private Boolean enabled;
	private Boolean lockUnLock;

	public SecureUser() {
		super();
	}

	public SecureUser(Long id, String username, String password, String name, Set<GrantedAuthority> list,
			Boolean lockUnLock) {
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setAuthorities(list);
		this.lockUnLock = lockUnLock;
		if (lockUnLock) {
			this.enabled = true;
		} else {
			this.enabled = false;
		}
	}



	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@JsonIgnore
	public Boolean getAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.getAccountNonExpired();
	}

	@JsonIgnore
	public Boolean getAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.getAccountNonLocked();
	}

	@JsonIgnore
	public Boolean getCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.getCredentialsNonExpired();
	}

	@JsonIgnore
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isEnabled() {
		return this.getEnabled();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getLockUnLock() {
		return lockUnLock;
	}

	public void setLockUnLock(Boolean lockUnLock) {
		this.lockUnLock = lockUnLock;
	}

}
