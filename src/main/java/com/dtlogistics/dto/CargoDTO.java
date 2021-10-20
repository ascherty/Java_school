package com.dtlogistics.dto;

import com.dtlogistics.models.modelEnum.CargoStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoDTO {

    private String cargoNumber;
    private String cargoName;
    private Integer weight;
    private CargoStatus status;
    private OrderDTO order;
    private WaypointDTO startWayPoint;
    private WaypointDTO endWayPoint;
}
