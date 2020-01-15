package com.techweaversys.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils {

	@Value("${security.token.secret}")
	private String secret;

	@Value("${security.token.expiration}")
	private Long expiration;
	private Claims body;

	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			created = new Date((Long) claims.get("created"));
		} catch (Exception e) {
			created = null;
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public String getAudienceFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			audience = (String) claims.get("audience");
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	private Date generateCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + this.expiration * 1000);
	}

	private Boolean isTokenExpired(String token) {
		boolean expired = false;
		final Date expiration = this.getExpirationDateFromToken(token);
		if(expiration == null){
			expired = true;
		}else{
			expired = expiration.before(this.generateCurrentDate());
		}
		return expired;
	}

	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", userDetails.getUsername());		
		claims.put("created", this.generateCurrentDate());
		return this.generateToken(claims);
	}
	
	public String generateObjectToken(SecureUser secureUser) {
        Claims claims = Jwts.claims().setSubject(secureUser.getUsername());
		claims.put("userId", secureUser.getId() + "");
		claims.put("role", secureUser.getAuthorities());     
		claims.put("created", this.generateCurrentDate());       
		return this.generateToken(claims);
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SecureUser parseToken(String token) {
        try {
			body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            SecureUser u = new SecureUser();
			u.setUsername(body.getSubject());
			u.setId(Long.parseLong((String) body.get("userId")));			
            Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
			for (Map role : (Collection<Map>) body.get("role")) {
            	roles.add(new SimpleGrantedAuthority((String) role.get("authority")));
			}
			u.setAuthorities(roles);
            return u;
        } catch (JwtException | ClassCastException e) {
			e.printStackTrace();
            return null;
        }
    }

	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(this.generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, this.secret).compact();
	}

	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
		final Date created = this.getCreatedDateFromToken(token);
		return (!(this.isCreatedBeforeLastPasswordReset(created, lastPasswordReset))
				&& (!(this.isTokenExpired(token))));
	}

	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			claims.put("created", this.generateCurrentDate());
			refreshedToken = this.generateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		return !(this.isTokenExpired(token));
	}
	
}
