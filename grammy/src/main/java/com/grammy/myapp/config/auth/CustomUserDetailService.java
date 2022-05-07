package com.grammy.myapp.config.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grammy.myapp.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUserId(userId).orElseThrow(()-> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
                
    }
}