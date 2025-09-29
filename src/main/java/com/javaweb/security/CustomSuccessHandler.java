package com.javaweb.security;

import com.javaweb.constant.SystemConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private boolean isAdmin(List<String> roles) {
        if (roles.contains(SystemConstant.ADMIN_ROLE) || roles.contains(SystemConstant.TEACHER_ROLE)) {
            return true;
        }
        return false;
    }

    private boolean isUser(List<String> roles) {
        if (roles.contains(SystemConstant.STUDENT_ROLE)) {
            return true;
        }
        return false;
    }
}
