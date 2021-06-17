package com.dtlogistics.services;

import com.dtlogistics.dao.TruckDAO;
import com.dtlogistics.dto.TruckDTO;
import com.dtlogistics.models.Truck;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckService {

    @Autowired
    private TruckDAO truckDAO;

    @Autowired
    private ModelMapper modelMapper;

    private TruckDTO convertToDto (Truck truck){
        return modelMapper.map(truck, TruckDTO.class);
    }

    private Truck convertToEntity (TruckDTO truckDto){
        return modelMapper.map(truckDto, Truck.class);
    }

    public TruckDTO findTruck(int id) {
        return convertToDto(truckDAO.findById(id));
    }

    public List<TruckDTO> findAllTrucks() {
        return truckDAO.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void saveTruck(TruckDTO truckDto) {
        truckDAO.save(convertToEntity(truckDto));
    }

    public void deleteTruck(TruckDTO truckDto) {
        truckDAO.delete(convertToEntity(truckDto));
    }

    public void updateTruck(TruckDTO truckDto) {
        truckDAO.update(convertToEntity(truckDto));
    }

}
