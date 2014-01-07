package com.petrpopov.voltmeter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by petrpopov on 07.01.14.
 */

@Document(collection = "voltstats")
public class VoltStat implements Serializable{

    @Id
    private String id;

    @NotNull
    private Date voteDate;

    @NotNull
    private VoltState state;

    public VoltStat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }

    public VoltState getState() {
        return state;
    }

    public void setState(VoltState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoltStat voltStat = (VoltStat) o;

        if (id != null ? !id.equals(voltStat.id) : voltStat.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
