package com.rakesh.taskflow.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AccountStatusValidator {
    public void validateAccountStatus(UserDetails userDetails) {
        if (!userDetails.isAccountNonExpired()) {
            throw new IllegalStateException("Account is expired");
        }
        if (!userDetails.isAccountNonLocked()) {
            throw new IllegalStateException("Account is locked");
        }
        if (!userDetails.isCredentialsNonExpired()) {
            throw new IllegalStateException("Credentials are expired");
        }
        if (!userDetails.isEnabled()) {
            throw new IllegalStateException("Account is disabled");
        }
    }
}
