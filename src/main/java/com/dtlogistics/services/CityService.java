package com.dtlogistics.services;

import com.dtlogistics.dao.CityDAO;
import com.dtlogistics.dto.CityDTO;
import com.dtlogistics.models.City;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private ModelMapper modelMapper;

    private CityDTO convertToDto (City city){
        return modelMapper.map(city, CityDTO.class);
    }

    private City convertToEntity (CityDTO cityDto){
        return modelMapper.map(cityDto, City.class);
    }

    public CityDTO findCity(int id) {
        return convertToDto(cityDAO.findById(id));
    }

    public List<CityDTO> findAllCities() {
        return cityDAO.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
