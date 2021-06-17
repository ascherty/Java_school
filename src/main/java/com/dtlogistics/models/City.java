package com.dtlogistics.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table (name = "cities")
public class City extends AbstractModel {

    @Column(name = "city")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Driver> driverList;

    @OneToMany(mappedBy = "city")
    private List<Truck> truckList;

    @OneToMany(mappedBy = "city")
    private List<Waypoint> waypointList;

    @OneToMany(mappedBy = "from", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Distance> from_id;

    @OneToMany(mappedBy = "to", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Distance> to_id;
}
