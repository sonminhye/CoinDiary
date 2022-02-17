package com.coin.diary.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coin.diary.entity.User;
import com.coin.diary.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(username);
		List<GrantedAuthority> roles = new ArrayList<>();
		
		return null;
	}

}
