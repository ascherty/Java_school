package com.dtlogistics.services;

import com.dtlogistics.dao.CityDAO;
import com.dtlogistics.dao.TruckDAO;
import com.dtlogistics.dto.TruckDTO;
import com.dtlogistics.models.City;
import com.dtlogistics.models.Truck;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckService {

    @Autowired
    private TruckDAO truckDAO;
    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private ModelMapper modelMapper;

    private TruckDTO convertToDto (Truck truck){
        return modelMapper.map(truck, TruckDTO.class);
    }

    private Truck convertToEntity (TruckDTO truckDto){
        return modelMapper.map(truckDto, Truck.class);
    }

    @Transactional
    public TruckDTO findTruck(String number) {
        return convertToDto(truckDAO.findByNumber(number));
    }

    @Transactional
    public List<TruckDTO> findAllTrucks() {
        return truckDAO.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveTruck(TruckDTO truckDto) {
        Truck newTruck = convertToEntity(truckDto);
        City city = cityDAO.findById(newTruck.getCity().getId());
        newTruck.setCity(city);
        truckDAO.save(newTruck);
    }

    @Transactional
    public void updateTruck(TruckDTO truckDto) {
        Truck editTruck = convertToEntity(truckDto);
        City city = cityDAO.findById(editTruck.getCity().getId());
        editTruck.setCity(city);
        truckDAO.update(editTruck);
    }

    @Transactional
    public void deleteTruck(String number) {
        Truck truck = truckDAO.findByNumber(number);
        truck.getDriverList().clear();
        truckDAO.save(truck);
        truckDAO.delete(truck);
    }

}
