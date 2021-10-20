package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.TruckCondition;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Truck.findByNumber",
                query = "SELECT t FROM Truck t WHERE t.number=:number")
})

@Entity
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Truck{" +
                "number='" + number + '\'' +
                ", capacity=" + capacity +
                ", condition=" + condition +
                '}';
    }
}
