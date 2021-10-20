package com.dtlogistics.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "distance")
public class Distance extends AbstractModel {

    private int distance;

//    @OneToOne(mappedBy = "from_id", fetch=FetchType.LAZY)
//    private Waypoint from;
//
//    @OneToOne(mappedBy = "to_id", fetch=FetchType.LAZY)
//    private Waypoint to;
}
