package com.np.hospital.management.exceptionHandling;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class ApiGatewayEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Custom Error: APIGatewayEntrypoint","AuthenticationFailed");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");

        String customErrorMsg = (authException != null && authException.getMessage() != null) ?
                authException.getMessage() : "Unauthorized";

        response.getWriter().write("Unauthorized Exception! APIGatewayEntryPoint, " +
                "CustomErrorMessage: "+customErrorMsg);
    }
}
