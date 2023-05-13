//package com.demo.mypay.security;
//
//import com.demo.mypay.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class JwtUserDetailsService implements UserDetailsService {
//
//	private final UserRepository userRepository;
//	private final PasswordEncoder bcryptEncoder;
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return username -> (UserDetails) userRepository.findByPhoneNo(username)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return null;
//	}
//}
