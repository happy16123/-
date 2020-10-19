package com.cloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloud.domain.UserDto;
import com.cloud.repo.UserDetailsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDetailsRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = userRepo.findByUsername(username);
		System.out.println(username);
		if(user == null) {
			throw new UsernameNotFoundException("유저 없음");
		}
		CustomUserDeatils principal = new CustomUserDeatils(user);
		return principal;
	}
 
}
