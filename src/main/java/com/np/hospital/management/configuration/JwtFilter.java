package com.np.hospital.management.configuration;

import com.np.hospital.management.utilities.JWTUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JWTUtility jwtUtility;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!(request.getRequestURI().contains("public")||request.getRequestURI().contains("h2"))) {
            try {
                String jwt = request.getHeader("JWT");
                if (jwt == null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("No JWT Token Present - Unauthorized User");
                    return;
                }

                if (jwt.contains("Bearer ")) {
                    jwt = jwt.substring(6);
                    System.out.println("Removed bearer, currentToken: " + jwt);
                }

                if (jwtUtility.validateToken(jwt)) {
                    String userName = jwtUtility.extractUserName(jwt);
                    UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                    Authentication authentication = new UsernamePasswordAuthenticationToken
                            (userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid JWT Token Present - Unauthorized User, Error Message: "+e.getMessage());
                return;
            }


        }
        filterChain.doFilter(request, response);
    }
}
