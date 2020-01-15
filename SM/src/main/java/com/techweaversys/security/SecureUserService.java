package com.techweaversys.security;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techweaversys.enums.StatusType;
import com.techweaversys.model.Role;
import com.techweaversys.model.User;
import com.techweaversys.repository.UserRepository;


@Service
public class SecureUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findOneByUsername(userName).orElseThrow(
		        () -> new UsernameNotFoundException(String.format("No user found with username '%s'.", userName)));
		if (user != null) {
			Boolean lockCheck = accountLockCheck(user.getStatus());
			SecureUser usr = new SecureUser(user.getId(), user.getUsername(), user.getPassword(), user.getName(),
			        getGrantedAuthorities(user.getRoles()), lockCheck);
			return usr;
		}
		return null;
	}
	
	private Set<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
		return roles.stream().map( r -> new SimpleGrantedAuthority(r.getRole()) ).collect(Collectors.toSet());
    }
	
	private Boolean accountLockCheck(String status) {
		return status.equals(StatusType.Active.getValue());
	}

}
