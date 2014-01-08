package com.petrpopov.voltmeter.services;

import com.google.common.base.Strings;
import com.petrpopov.voltmeter.model.VoltStat;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by petrpopov on 07.01.14.
 */

@Component
public class VoltStatService extends GenericService<VoltStat> {

    public VoltStatService() {
        super(VoltStat.class);
        logger = Logger.getLogger(VoltStatService.class);
    }

    public VoltStat getLastForCookie(String cookie) {

        Query query = new Query();
        Criteria crit = Criteria.where("cookie").is(cookie);
        query.addCriteria(crit);

        List<VoltStat> list = op.find(query, domainClass);
        if( list.isEmpty() ) {
            return null;
        }

        VoltStat last = list.get(0);
        DateTime lastTime = new DateTime(last.getVoteDate());

        for (VoltStat voltStat : list) {
            DateTime voteTime = new DateTime(voltStat.getVoteDate());
            if( lastTime.isAfter(voteTime) ) {
                lastTime = voteTime;
                last = voltStat;
            }
        }

        return last;
    }

    public VoltStat createOrSave(@Valid VoltStat stat) {

        String id = stat.getId();
        if( !Strings.isNullOrEmpty(id)) {
            VoltStat byId = this.findById(id);

            VoltStat voltStat;
            if( byId != null ) {
                byId.setState(stat.getState());
                byId.setVoteDate(stat.getVoteDate());
                voltStat = this.save(byId);
            }
            else {
                voltStat = doSave(stat);
            }

            return voltStat;
        }

        VoltStat voltStat = doSave(stat);
        return voltStat;
    }

    private VoltStat doSave(VoltStat stat) {
        VoltStat save = this.save(stat);
        return save;
    }

}
