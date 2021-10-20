package com.dtlogistics.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WaypointDTO {

    private boolean passed;
    private int queue;
    private OrderDTO order;
    private CityDTO city;

}
