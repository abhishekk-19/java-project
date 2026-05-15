package com.ecommerce.service;

import com.ecommerce.model.AppUser;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        AppUser appUser = userOpt.get();

        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(appUser.getRole().replace("ROLE_", "")) // Spring Security expects role without ROLE_ prefix in builder
                .build();
    }
}
