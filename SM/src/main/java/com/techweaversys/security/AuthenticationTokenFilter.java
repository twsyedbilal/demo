package com.techweaversys.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

  @Value("${security.token.header}")
  private String tokenHeader;

  @Autowired
  private TokenUtils tokenUtils;
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	  
	  
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String authToken = httpRequest.getHeader(this.tokenHeader);   
    
    if (tokenUtils.validateToken(authToken, null)) { 
    	SecureUser secureUser = tokenUtils.parseToken(authToken);  
    	String username = secureUser.getUsername();    
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(secureUser, null, secureUser.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            ((HttpServletResponse)response).addHeader("refreshToken", tokenUtils.refreshToken(authToken));
        }
    }
    chain.doFilter(request, response);
    
	}

}
