package com.dtlogistics.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkshiftDTO {

    private Date shiftStart;
    private Date shiftEnd;
    private DriverDTO driver;
}
