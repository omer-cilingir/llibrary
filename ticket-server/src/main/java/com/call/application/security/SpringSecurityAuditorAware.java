package com.call.application.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.call.application.config.Constants;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        String username = SecurityUtils.getCurrentUsername();
        return username != null ? username : Constants.SYSTEM_ACCOUNT;
    }
}
