package com.petrpopov.voltmeter.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: petrpopov
 * Date: 02.07.13
 * Time: 17:18
 */
@Controller
public class HomeController {

    @RequestMapping({"/","/home", "/index", "/main"})
    public String showHomePage() {
        return "index";
    }
}
