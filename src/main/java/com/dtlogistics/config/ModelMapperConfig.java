package com.dtlogistics.config;

import com.dtlogistics.dto.DriverDTO;
import com.dtlogistics.dto.TruckDTO;
import com.dtlogistics.models.Driver;
import com.dtlogistics.models.Truck;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public TypeMap<Driver, DriverDTO> getDriverDTOTypeMap() {
//        return modelMapper().createTypeMap(Driver.class, DriverDTO.class, "DriverDTO")
//                .addMappings(mapper -> mapper.using(MappingContext::getDestination).map(Driver::getOrder, DriverDTO::setOrder))
//                .addMappings(mapper -> mapper.using(MappingContext::getDestination).map(Driver::getWorkshiftList, DriverDTO::setWorkshiftList))
//                .addMappings(mapper -> mapper.using(MappingContext::getDestination).map(Driver::getTruck, DriverDTO::setTruck));
//    }
//
//    @Bean
//    public TypeMap<Truck, TruckDTO> getTruckDTOTypeMap() {
//        return modelMapper().createTypeMap(Truck.class, TruckDTO.class, "TruckDTO")
//                .addMappings(mapper -> mapper.using(MappingContext::getDestination).map(Truck::getCity, TruckDTO::setCity))
//                .addMappings(mapper -> mapper.using(MappingContext::getDestination).map(Truck::getOrder, TruckDTO::setOrder))
//                .addMappings(mapper -> mapper.using(MappingContext::getDestination).map(Truck::getDriverList, TruckDTO::setDriverList));
//    }


}
