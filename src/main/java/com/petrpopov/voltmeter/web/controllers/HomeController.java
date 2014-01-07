package com.petrpopov.voltmeter.web.controllers;


import org.springframework.beans.factory.annotation.Value;
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

    @Value("${min_voltmeter}")
    private Integer minVoltmeter;

    @Value("${max_voltmeter}")
    private Integer maxVoltmeter;

    @RequestMapping({"/","/home", "/index", "/main"})
    public String showHomePage() {
        return "index";
    }

    @RequestMapping(value = "voltmeter/{voltmeterid}")
    public ModelAndView showVoltmeterPage(@PathVariable String voltmeterid) {

        try {
            Long id = Long.parseLong(voltmeterid);
            if( id <= minVoltmeter || id >= maxVoltmeter )
                return new ModelAndView("error");
        }
        catch(Exception e) {
            return new ModelAndView("error");
        }


        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("voltmeterid", voltmeterid);

        return modelAndView;
    }
}
