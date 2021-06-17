package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table (name = "orders")
public class Order extends AbstractModel {

    private String identifier;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Cargo> cargoList;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Waypoint> waypointList;

    @OneToOne(mappedBy = "order")
    private Truck truck;

}
