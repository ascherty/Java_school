package com.dtlogistics.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table (name = "workshift")
public class Workshift extends AbstractModel {

    @Temporal(TemporalType.TIMESTAMP)
    private Date shiftStart;

    @Temporal(TemporalType.TIMESTAMP)
    private Date shiftEnd;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    private Driver driver;

}
