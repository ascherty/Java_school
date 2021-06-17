package com.dtlogistics.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "distance")
public class Distance extends AbstractModel {

    private int distance;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "from_id", referencedColumnName = "id", nullable = false)
    private Waypoint from;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "to_id", referencedColumnName = "id", nullable = false)
    private Waypoint to;
}
