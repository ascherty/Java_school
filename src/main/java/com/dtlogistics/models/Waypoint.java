package com.dtlogistics.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "waypoints")
public class Waypoint extends AbstractModel {

    private boolean passed;
    private int queue;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "startWayPoint", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Cargo> startWayPoint_id;

    @OneToMany(mappedBy = "endWayPoint", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Cargo> endWayPoint_id;

}
