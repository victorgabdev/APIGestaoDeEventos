package com.victorgabriel.eventos.shared.security;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerToken = request.getHeader("Authorization");

        if(headerToken != null) {
            String auth = headerToken.replace("Bearer ", "");
            if(auth.equals("tokenDeTesteUlala")) {
                // alguma coisa
            } else {
                response.setStatus(401);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
