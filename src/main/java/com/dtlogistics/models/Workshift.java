package com.dtlogistics.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table (name = "workshift")
public class Workshift extends AbstractModel {

    @Temporal(TemporalType.TIMESTAMP)
    private Date shiftStart;

    @Temporal(TemporalType.TIMESTAMP)
    private Date shiftEnd;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    private Driver driver;

    @Override
    public String toString() {
        return "Workshift{" +
                "shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                ", driver=" + driver +
                '}';
    }
}
