package com.example.authservletjwt.util;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonResponseUtil {
    private static final Gson gson = new Gson();
    public static void writeResponse(HttpServletResponse response, int statusCode, String message, String errorCode) throws IOException {
        response.setStatus(statusCode);
        response.setContentType("application/json");

        Map<String, Object> json = new HashMap<>();
        json.put("message", message);
        json.put("errorCode", errorCode);
        json.put("statusCode", statusCode);

        response.getWriter().write(gson.toJson(json));
    }
}
