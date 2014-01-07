package com.petrpopov.voltmeter.web.controllers;

import com.petrpopov.voltmeter.model.VoltStat;
import com.petrpopov.voltmeter.services.VoltStatService;
import com.petrpopov.voltmeter.web.other.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by petrpopov on 07.01.14.
 */

@Controller
@RequestMapping(value = "/stats")
public class VoltStatController {

    @Autowired
    private VoltStatService statService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object voteForStats(@Valid @RequestBody VoltStat stat) {

        VoltStat save = statService.save(stat);
        return Message.okMessage(save);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Object all() {
        return statService.findAll();
    }
}
