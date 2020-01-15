package com.techweaversys.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techweaversys.security.AuthenticationTokenFilter;
import com.techweaversys.security.EntryPointUnauthorizedHandler;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private EntryPointUnauthorizedHandler unauthorizedHandler;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.userDetailsService)
		.passwordEncoder(passwordEncoder());
	}

	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	@Bean
	    public static NoOpPasswordEncoder passwordEncoder() {
	        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	    }

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
		authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
		return authenticationTokenFilter;
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().exceptionHandling().authenticationEntryPoint(this.unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
		        .antMatchers("/socket").permitAll()
				.antMatchers(
				    "/",
		                "/public/**", "/socket/**",
		                "/login", 
		                "/mail",
					"/assets/image/**",
						"/images/**",
					"/assets/pdf/**",
						"/favicon-icon.svg",
					"/**/*.html",
					"/**/*.css",
					"/**/*.js",
					"/**/*.png",
					"/**/*.jpg",
					"/**/*.eot",
					"/**/*.woff",
					"/**/*.woff2",
					"/**/*.ttf",
					"/img/**"
				).permitAll().anyRequest().authenticated();

		// Custom JWT based authentication
		httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		web.ignoring().antMatchers("/socket");
		web.ignoring().antMatchers("/socket/**");
	}
	
}
