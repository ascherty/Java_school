package com.dtlogistics.services;

import com.dtlogistics.dao.DriverDAO;
import com.dtlogistics.dto.DriverDTO;
import com.dtlogistics.models.Driver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverDAO driverDAO;

    @Autowired
    private ModelMapper modelMapper;

    private DriverDTO convertToDto (Driver driver){
        return modelMapper.map(driver, DriverDTO.class);
    }

    private Driver convertToEntity (DriverDTO driverDto){
        return modelMapper.map(driverDto, Driver.class);
    }

    public DriverDTO findDriver(int id) {
        return convertToDto(driverDAO.findById(id));
    }

    public List<DriverDTO> findAllDrivers() {
        return driverDAO.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void saveDriver(DriverDTO driverDto) {
        Driver driver = new Driver();
        modelMapper.map(driverDto, Driver.class);
        driverDAO.save(driver);
    }

//    public void deleteUser(Driver driver) {
//        driversDao.delete(driver);
//    }
//
//    public void updateUser(Driver driver) {
//        driversDao.update(driver);
//    }

}
