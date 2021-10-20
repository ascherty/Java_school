package com.dtlogistics.models;

import com.dtlogistics.models.modelEnum.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "User.findByName",
                query = "SELECT u FROM User u WHERE u.name=:name"),
        @NamedQuery(name = "User.findByEmail",
                query = "SELECT u FROM User u WHERE u.email=:email")
})

@Entity
@Getter
@Setter
@Table (name = "users")
public class User extends AbstractModel {

    private String name;
    private String surname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
