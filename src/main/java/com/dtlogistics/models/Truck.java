package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.TruckCondition;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table (name = "trucks")
public class Truck extends AbstractModel {

    private String number;
    private int capacity;

    @Enumerated(EnumType.STRING)
    private TruckCondition condition;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToMany(mappedBy = "truck")
    private List<Driver> driverList;

}
