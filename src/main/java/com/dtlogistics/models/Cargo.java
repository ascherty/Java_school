package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.CargoStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table (name = "cargos")
public class Cargo extends AbstractModel {

    private String cargoNumber;
    private String cargoName;
    private Integer weight;

    @Enumerated(EnumType.STRING)
    private CargoStatus status;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "startWayPoint_id", referencedColumnName = "id", nullable = false)
    private Waypoint startWayPoint;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "endWayPoint_id", referencedColumnName = "id", nullable = false)
    private Waypoint endWayPoint;

}
