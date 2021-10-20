package com.dtlogistics.services;

import com.dtlogistics.dao.UserDAO;
import com.dtlogistics.dto.TruckDTO;
import com.dtlogistics.dto.UserDTO;
import com.dtlogistics.models.Truck;
import com.dtlogistics.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper modelMapper;

    private UserDTO convertToDto (User user){
        return modelMapper.map(user, UserDTO.class);
    }

    private User convertToEntity (UserDTO userDto){
        return modelMapper.map(userDto, User.class);
    }

    @Transactional
    public UserDTO findUser(String name) {
        return convertToDto(userDAO.findByName(name));
    }
    @Transactional
    public List<UserDTO> findAllUsers() {
        return userDAO.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @Transactional
    public void saveUser(UserDTO userDto) {
        userDAO.save(convertToEntity(userDto));
    }

    @Transactional
    public void updateUser(UserDTO userDto) {
        userDAO.update(convertToEntity(userDto));
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userDAO.findByName(name);
        userDAO.delete(user);
    }
}