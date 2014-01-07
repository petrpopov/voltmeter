package com.petrpopov.voltmeter.services;

import com.google.common.base.Strings;
import com.petrpopov.voltmeter.model.VoltStat;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Created by petrpopov on 07.01.14.
 */

@Component
public class VoltStatService extends GenericService<VoltStat> {

    public VoltStatService() {
        super(VoltStat.class);
        logger = Logger.getLogger(VoltStatService.class);
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
