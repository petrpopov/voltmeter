package com.petrpopov.voltmeter.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "voltmeter/{voltmeterid}")
    public ModelAndView showVoltmeterPage(@PathVariable String voltmeterid) {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("voltmeterid", voltmeterid);

        return modelAndView;
    }
}
