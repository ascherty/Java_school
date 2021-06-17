package com.dtlogistics.dto;

import com.dtlogistics.models.Distance;
import com.dtlogistics.models.Driver;
import com.dtlogistics.models.Truck;
import com.dtlogistics.models.Waypoint;
import lombok.Data;

import java.util.List;

@Data
public class CityDTO {

    private String name;
    private List<Driver> driverList;
    private List<Truck> truckList;
    private List<Waypoint> waypointList;
    private List<Distance> from_id;
    private List<Distance> to_id;
}
