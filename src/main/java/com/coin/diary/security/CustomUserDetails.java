package com.coin.diary.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetails implements UserDetails{

	private String username;
	private String password;
	private String korNm;
	private boolean isEnabled;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Builder
	public CustomUserDetails(String username, String password, String korNm
								, Collection<? extends GrantedAuthority> authorities
							    , boolean isEnabled, boolean isAccountNonExpired, boolean isAccountNonLocked
							    , boolean isCredentialsNonExpired) {
		this.username = username;
		this.password = password;
		this.korNm = korNm;
		this.isEnabled = isEnabled;
		this.authorities = authorities;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	
}
