package com.dtlogistics.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

//    @OneToOne(cascade=CascadeType.ALL)
//    private Distance from_id;
//
//    @OneToOne(cascade=CascadeType.ALL)
//    private Distance to_id;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
