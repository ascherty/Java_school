package com.dtlogistics.dto;

import com.dtlogistics.models.modelEnum.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String surname;
    private String email;
    private String password;
    private UserRole role;
}
