package com.dtlogistics.controllers;

import com.dtlogistics.dto.CityDTO;
import com.dtlogistics.dto.DriverDTO;
import com.dtlogistics.services.CityService;
import com.dtlogistics.services.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;
    private final CityService cityService;

    public DriverController(DriverService driverService, CityService cityService) {
        this.driverService = driverService;
        this.cityService = cityService;
    }

    @GetMapping()
    public String driversAll(Model model) {
        model.addAttribute("drivers", driverService.findAllDrivers());
        model.addAttribute("cities", cityService.findAllCities());
        return "drivers/driversAll";
    }


    @GetMapping("/{privateNumber}")
    public String driverDetails(@PathVariable("privateNumber") String privateNumber, Model model) {
        model.addAttribute("driver", driverService.findDriver(privateNumber));
        return "drivers/driverDetails";
    }

    @GetMapping("/new")
    public String newDriver(Model model) {
        DriverDTO driverDto = new DriverDTO();
        driverDto.setCity(new CityDTO());
        model.addAttribute("driver", driverDto);
        model.addAttribute("cities", cityService.findAllCities());
        return "drivers/newDriver";
    }

    @PostMapping("/newDriver")
    public String saveDriver(@ModelAttribute("driver") DriverDTO driverDto, Model model) {
        driverService.saveDriver(driverDto);
        return "redirect:/drivers";
    }

    @GetMapping("/edit/{privateNumber}")
    public String editDriver(@PathVariable("privateNumber") String privateNumber, Model model) {
        DriverDTO driverDto = driverService.findDriver(privateNumber);
        model.addAttribute("driver", driverDto);
        model.addAttribute("cities", cityService.findAllCities());
        return "drivers/editDriver";
    }

    @PostMapping("/editDriver")
    public String updateDriver(@ModelAttribute("driver") DriverDTO driverDto, Model model) {
        driverService.updateDriver(driverDto);
        return "redirect:/drivers";
    }

    @GetMapping("/delete/{privateNumber}")
    public String deleteDriver(@PathVariable("privateNumber") String privateNumber) {
        driverService.deleteDriver(privateNumber);
        return "redirect:/drivers";
    }

}
