package com.dtlogistics.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {

    private String name;

//    private Distance from_id;
//    private Distance to_id;

    @Override
    public String toString() {
        return "CityDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
