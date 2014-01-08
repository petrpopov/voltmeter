package com.petrpopov.voltmeter.web.controllers;

import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * User: petrpopov
 * Date: 08.01.14
 * Time: 19:40
 */

@Controller
public class BasicController {

    private static String COOKIE = "VOLTMETER";

    protected String setNewCookie(HttpServletResponse response) {
        String cookie = UUID.randomUUID().toString();
        response.addCookie(new Cookie(COOKIE, cookie));

        return cookie;
    }
}
