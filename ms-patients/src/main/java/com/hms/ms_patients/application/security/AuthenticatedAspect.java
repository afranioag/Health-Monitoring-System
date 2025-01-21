package com.hms.ms_patients.application.security;

import com.hms.ms_patients.domain.security.anotations.Authenticated;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AuthenticatedAspect {

    @Around("@annotation(authenticated)")
    public Object validateAuthentication(ProceedingJoinPoint joinPoint, Authenticated authenticated) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("User not authenticated");
        }

        String[] allowedRoles = authenticated.value();
        String userRole = authentication.getAuthorities().iterator().next().getAuthority();

        if (!Arrays.asList(allowedRoles).contains(userRole)) {
            throw new AccessDeniedException("User does not have the required role");
        }

        return joinPoint.proceed();
    }
}