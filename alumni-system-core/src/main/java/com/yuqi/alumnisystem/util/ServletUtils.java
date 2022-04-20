package com.yuqi.alumnisystem.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuexi.guo
 * @date 2022/4/20 11:08
 */
public final class ServletUtils {
    private ServletUtils() {
    }

    public static RequestAttributes getRequestAttributes() {
        return RequestContextHolder.getRequestAttributes();
    }

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) getRequestAttributes();
    }

    public static HttpServletRequest getHttpServletRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        return getServletRequestAttributes().getResponse();
    }

    public static Object getAttribute(String name) {
        return getHttpServletRequest().getAttribute(name);
    }

    public static <T> T getAttribute(String name, Class<T> type) {
        Object o = getAttribute(name);
        if (o == null) {
            return null;
        }
        return type.cast(o);
    }

    public static void setAttribute(String name, Object o) {
        getHttpServletRequest().setAttribute(name, o);
    }

    public static void removeAttribute(String name) {
        getHttpServletRequest().removeAttribute(name);
    }

    public static String getHeader(String name) {
        return getHttpServletRequest().getHeader(name);
    }

    public static void setHeader(String name, String value) {
        getHttpServletResponse().setHeader(name, value);
    }

}
