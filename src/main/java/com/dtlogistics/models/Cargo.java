package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.CargoStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoNumber='" + cargoNumber + '\'' +
                ", cargoName='" + cargoName + '\'' +
                ", weight=" + weight +
                ", status=" + status +
                '}';
    }
}
