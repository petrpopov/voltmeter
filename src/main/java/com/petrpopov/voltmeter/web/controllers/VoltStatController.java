package com.petrpopov.voltmeter.web.controllers;

import com.petrpopov.voltmeter.model.VoltStat;
import com.petrpopov.voltmeter.model.VoltState;
import com.petrpopov.voltmeter.services.VoltStatService;
import com.petrpopov.voltmeter.web.other.Message;
import com.petrpopov.voltmeter.web.other.VoltStatDTO;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

import static java.util.Collections.sort;

/**
 * Created by petrpopov on 07.01.14.
 */

@Controller
@RequestMapping(value = "/stats")
public class VoltStatController extends BasicController {

    @Autowired
    private VoltStatService statService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object voteForStats(@Valid @RequestBody VoltStat stat,
                               @CookieValue(required = false, value = "VOLTMETER") String cookie,
                               HttpServletResponse response) {

        String cookieString = cookie;
        if( cookie == null ) {
            cookieString = setNewCookie(response);
        }

        if( cookieString != null ) {
            VoltStat lastForCookie = statService.getLastForCookie(cookie);
            if( lastForCookie != null ) {
                if( lastForCookie.getVoteDate() != null ) {
                    DateTime lastTime = new DateTime(lastForCookie.getVoteDate());

                    DateTime curTime = new DateTime(new Date());

                    Days days = Days.daysBetween(curTime, lastTime);
                    int days1 = days.getDays();
                    if( days1 < 1 ) {
                        return Message.okMessage();
                    }
                }
            }

        }

        stat.setCookie(cookieString);
        VoltStat save = statService.save(stat);
        return Message.okMessage(save);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Object all() {

        Map<Integer, Long> statRes = new HashMap<Integer, Long>();

        List<VoltStatDTO> res = new ArrayList<VoltStatDTO>();

        List<VoltStat> all = statService.findAll();
        for (VoltStat voltStat : all) {
            Long val = new Long(0);
            Integer key = voltStat.getState().getVal();

            if( !statRes.containsKey(key)) {
                statRes.put(key, val);
            }
            else {
                val = statRes.get(key);
            }

            val = val+1;
            statRes.put(key, val);
        }

        for (VoltState voltState : VoltState.values()) {
            int val = voltState.getVal();
            if( !statRes.containsKey(val) )
                statRes.put(val, new Long(0));
        }


        for (Map.Entry<Integer, Long> entry : statRes.entrySet()) {
            VoltStatDTO dto = new VoltStatDTO();
            dto.setState(entry.getKey());
            dto.setCount(entry.getValue());
            res.add(dto);
        }

        sort(res);

        return res;
    }
}
