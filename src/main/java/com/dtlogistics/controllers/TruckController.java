package com.dtlogistics.controllers;

import com.dtlogistics.dto.CityDTO;
import com.dtlogistics.dto.TruckDTO;
import com.dtlogistics.services.CityService;
import com.dtlogistics.services.TruckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trucks")
public class TruckController {

    private final TruckService truckService;
    private final CityService cityService;

    public TruckController(TruckService truckService, CityService cityService) {
        this.truckService = truckService;
        this.cityService = cityService;
    }

    @GetMapping()
    public String trucksAll(Model model) {
        model.addAttribute("trucks", truckService.findAllTrucks());
        model.addAttribute("cities", cityService.findAllCities());
        return "trucks/trucksAll";
    }


    @GetMapping("/{number}")
    public String truckDetails(@PathVariable("number") String number, Model model) {
        model.addAttribute("truck", truckService.findTruck(number));
        return "trucks/truckDetails";
    }

    @GetMapping("/new")
    public String newTruck(Model model) {
        TruckDTO truckDto = new TruckDTO();
        truckDto.setCity(new CityDTO());
        model.addAttribute("truck", truckDto);
        model.addAttribute("cities", cityService.findAllCities());
        return "trucks/newTruck";
    }

    @PostMapping("/newTruck")
    public String saveTruck(@ModelAttribute("truck") TruckDTO truckDto, Model model) {
        truckService.saveTruck(truckDto);
        return "redirect:/trucks";
    }

    @GetMapping("/edit/{number}")
    public String editTruck(@PathVariable("number") String number, Model model) {
        TruckDTO truckDto = truckService.findTruck(number);
        model.addAttribute("truck", truckDto);
        model.addAttribute("cities", cityService.findAllCities());
        return "trucks/editTruck";
    }

    @PostMapping("/editTruck")
    public String updateTruck(@ModelAttribute("truck") TruckDTO truckDto, Model model) {
        truckService.updateTruck(truckDto);
        return "redirect:/trucks";
    }

    @GetMapping("/delete/{number}")
    public String deleteTruck(@PathVariable("number") String number) {
        truckService.deleteTruck(number);
        return "redirect:/trucks";
    }

}
