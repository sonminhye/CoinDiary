package com.coin.diary.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coin.diary.entity.User;
import com.coin.diary.entity.UserRole;
import com.coin.diary.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optUser = userRepository.findById(username);
		User user = optUser.get();
		CustomUserDetails details = CustomUserDetails.builder()
													 .username(user.getUsername())
													 .password(user.getPassword())
													 .korNm(user.getKorNm())
													 .isEnabled(true)
													 .isAccountNonLocked(true)
													 .isAccountNonExpired(true)
													 .isCredentialsNonExpired(true)
													 .authorities(getAuthorities(user.getUserRole()))
													 .build();
		
													
		return details;
	}
	
	public Collection<GrantedAuthority> getAuthorities(Collection<UserRole> userRoleList){
       
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRoleCd()));
        }
        return authorities;

	}
	
}
