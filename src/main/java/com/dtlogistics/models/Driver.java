package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.DriverStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Driver.findByPrivateNumber",
                query = "SELECT d FROM Driver d WHERE d.privateNumber=:privateNumber")
})

@Entity
@Getter
@Setter
@Table (name = "drivers")
public class Driver extends AbstractModel {

    private String privateNumber;

    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "truck_id", referencedColumnName = "id")
    private Truck truck;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Workshift> workshiftList;

    @Override
    public String toString() {
        return "Driver{" +
                "privateNumber='" + privateNumber + '\'' +
                ", status=" + status +
                '}';
    }
}
