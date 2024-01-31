package com.example.security.services;

import com.example.security.repository.UserRepository;
import com.example.security.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        var u = userRepository.findUserByUsername(username);
        return u.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
