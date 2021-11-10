package com.dataart.javaschool.newsportal.security;

import com.dataart.javaschool.newsportal.entity.User;
import com.dataart.javaschool.newsportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLOGIN(login).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(user);
    }
}
