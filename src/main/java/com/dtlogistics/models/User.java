package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.UserRole;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table (name = "users")
public class User extends AbstractModel {

    private String name;
    private String surname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "user")
    private Driver driver;
}
