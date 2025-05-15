package com.rakesh.taskflow.service.security;

import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.entity.UserPrincipal;
import com.rakesh.taskflow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TaskFlowUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AccountStatusValidator validator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        UserDetails userDetails = new UserPrincipal(user);
        validator.validateAccountStatus(userDetails);
        return userDetails;
    }
}
