package com.dtlogistics.dto;

import com.dtlogistics.models.City;
import com.dtlogistics.models.Driver;
import com.dtlogistics.models.Order;
import com.dtlogistics.models.modelEnum.TruckCondition;
import lombok.Data;

import java.util.List;

@Data
public class TruckDTO {

    private String number;
    private int capacity;
    private TruckCondition condition;
    private City city;
    private Order order;
    private List<Driver> driverList;

}
