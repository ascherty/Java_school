package com.dtlogistics.dto;

import com.dtlogistics.models.*;
import com.dtlogistics.models.modelEnum.DriverStatus;
import lombok.Data;

import java.util.List;

@Data
public class DriverDTO {

    private String privateNumber;
    private boolean currentDriver;
    private DriverStatus status;
    private User user;
    private City city;
    private Truck truck;
    private List<Workshift> workshiftList;

}
