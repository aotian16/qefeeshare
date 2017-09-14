package com.qefee.qefeeshare.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

    public static String getClientIp(HttpServletRequest request) {

        String remoteAddress = "";

        if (request != null) {
            remoteAddress = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddress == null || "".equals(remoteAddress)) {
                remoteAddress = request.getRemoteAddr();
            }
        }

        return remoteAddress;
    }

}
