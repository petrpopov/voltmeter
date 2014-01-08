package com.petrpopov.voltmeter.web.other;

/**
 * User: petrpopov
 * Date: 08.01.14
 * Time: 19:20
 */

public class CookieRequest {

    private String cookie;

    public CookieRequest() {
    }

    public CookieRequest(String cookie) {
        this.cookie = cookie;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
