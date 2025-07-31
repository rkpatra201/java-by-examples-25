package com.example.authservletjwt.filter;

import com.example.authservletjwt.exceptions.UserCreationException;
import com.example.authservletjwt.exceptions.ValidationException;
import com.example.authservletjwt.util.JsonResponseUtil;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import com.example.authservletjwt.exceptions.UnauthorizedException;

import java.io.IOException;

@WebFilter("/*")
public class GlobalExceptionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResp = (HttpServletResponse) response;

        try {
            chain.doFilter(request, response); // continue to next filter/servlet
        } catch (ValidationException ve) {
            JsonResponseUtil.writeResponse(httpResp, 400, ve.getMessage(), "VALIDATION_ERROR");

        } catch (UserCreationException ue) {
            JsonResponseUtil.writeResponse(httpResp, 400, ue.getMessage(), "USER_CREATION_FAILED");

        } catch (JsonSyntaxException jse) {
            JsonResponseUtil.writeResponse(httpResp, 400, "Malformed JSON input", "MALFORMED_JSON");

        } catch (UnauthorizedException ue) {
            JsonResponseUtil.writeResponse(httpResp, 401, ue.getMessage(), "UNAUTHORIZED");
        } catch (Exception e) {
            e.printStackTrace(); // optional: log to file or external logger
            JsonResponseUtil.writeResponse(httpResp, 500, "Internal Server Error", "INTERNAL_ERROR");
        }
    }
    @Override
    public void destroy() {}
}
