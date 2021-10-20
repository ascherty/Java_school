package com.dtlogistics.dto;

import com.dtlogistics.models.modelEnum.TruckCondition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TruckDTO {

    private String number;
    private int capacity;
    private TruckCondition condition;
    private CityDTO city;
    private OrderDTO order;
    private List<DriverDTO> driverList;

}
