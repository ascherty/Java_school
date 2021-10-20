package com.dtlogistics.dto;

import com.dtlogistics.models.modelEnum.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private String identifier;
    private OrderStatus status;
    private List<CargoDTO> cargoList;
    private List<DriverDTO> driverList;
    private List<WaypointDTO> waypointList;
    private TruckDTO truck;
}
