package com.example.filter;


import com.example.model.ErrorResponse;
import com.example.util.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import java.io.IOException;

@WebFilter("/*")
public class ExceptionHandlingFilter implements Filter {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        try {
            chain.doFilter(request, response);
        } catch (ApiException e){
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(e.getStatusCode());
            httpServletResponse.setContentType("application/json");
            ErrorResponse err = new ErrorResponse(e.getMessage(), e.getErrorCode(), e.getStatusCode());
            httpServletResponse.getWriter().write(mapper.writeValueAsString(err));
        } catch (Exception e){
            HttpServletResponse httpServletResp = (HttpServletResponse) response;
            httpServletResp.setStatus(500);
            httpServletResp.setContentType("application/json");
            ErrorResponse errorResponse = new ErrorResponse("Internal Server Error","INTERNAL_SERVER_ERROR", 500);
            httpServletResp.getWriter().write(mapper.writeValueAsString(errorResponse));
        }
    }
}
