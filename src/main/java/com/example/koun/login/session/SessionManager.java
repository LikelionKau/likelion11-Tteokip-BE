package com.example.koun.login.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;



@Component
public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    public void createSession(Object value, HttpServletResponse response) {
        //세션 생성
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);
        System.out.println("Session created: sessionId=" + sessionId + ", value=" + value);

        //쿠키 생성 후 저장
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(cookie);
    }

    public Object getSession(HttpServletRequest request) {
        Cookie cookie = findCookie(request, SESSION_COOKIE_NAME);
        if (cookie == null) {
            return null;
        }
        Object value = sessionStore.get(cookie.getValue());
        System.out.println("Session retrieved: sessionId=" + cookie.getValue() + ", value=" + value);
        return value;
    }

    public void expire(HttpServletRequest request) {
        Cookie cookie = findCookie(request, SESSION_COOKIE_NAME);
        if (cookie != null) {
            sessionStore.remove(cookie.getValue());
            System.out.println("Session expired: sessionId=" + cookie.getValue());
        }
    }

    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }

        return Arrays.stream(request.getCookies())
            .filter(c -> c.getName().equals(cookieName))
            .findAny()
            .orElse(null);
    }
}
