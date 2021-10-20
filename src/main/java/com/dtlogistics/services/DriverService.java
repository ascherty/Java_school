package com.dtlogistics.services;

import com.dtlogistics.dao.CityDAO;
import com.dtlogistics.dao.DriverDAO;
import com.dtlogistics.dto.DriverDTO;
import com.dtlogistics.models.City;
import com.dtlogistics.models.Driver;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverDAO driverDAO;
    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private ModelMapper modelMapper;

    private DriverDTO convertToDto (Driver driver){
        return modelMapper.map(driver, DriverDTO.class);
    }

    private Driver convertToEntity (DriverDTO driverDto){
        return modelMapper.map(driverDto, Driver.class);
    }

    @Transactional
    public DriverDTO findDriver(String privateNumber) {
        return convertToDto(driverDAO.findByPrivateNumber(privateNumber));
    }

    @Transactional
    public List<DriverDTO> findAllDrivers() {
        return driverDAO.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveDriver(DriverDTO driverDto) {
        Driver newDriver = convertToEntity(driverDto);
        City city = cityDAO.findById(newDriver.getCity().getId());
        newDriver.setCity(city);
        driverDAO.save(newDriver);
    }

    @Transactional
    public void updateDriver(DriverDTO driverDto) {
        Driver editDriver = convertToEntity(driverDto);
        City city = cityDAO.findById(editDriver.getCity().getId());
        editDriver.setCity(city);
        driverDAO.update(editDriver);
    }

    @Transactional
    public void deleteDriver(String privateNumber) {
        Driver driver = driverDAO.findByPrivateNumber(privateNumber);
        driverDAO.delete(driver);
    }

}
