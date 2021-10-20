package com.dtlogistics.dto;

import com.dtlogistics.models.modelEnum.DriverStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DriverDTO {

    private String privateNumber;
    private DriverStatus status;
    private UserDTO user;
    private CityDTO city;
    private TruckDTO truck;
    private OrderDTO order;
    private List<WorkshiftDTO> workshiftList;

}