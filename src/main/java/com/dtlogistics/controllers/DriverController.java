package com.dtlogistics.controllers;

import com.dtlogistics.dto.DriverDTO;
import com.dtlogistics.models.Driver;
import com.dtlogistics.services.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping()
    public String driversAll(Model model) {
        model.addAttribute("drivers", driverService.findAllDrivers());
        return "drivers/driversAll";
    }

    @GetMapping("/{id}")
    public String driverDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("driver", driverService.findDriver(id));
        return "drivers/driverDetails";
    }



    @PostMapping()
    public String saveDriver(@ModelAttribute("driver") DriverDTO driverDto) {
        driverService.saveDriver(driverDto);
        return "redirect:drivers";
    }

//    @PostMapping
//    public String saveDriver(@RequestParam String name, @RequestParam String surname, @RequestParam int privateNumber, @RequestParam int workHours, @RequestParam String status, @RequestParam String city, @RequestParam String truck, Model model) {
//        Driver driver = new Driver(name, surname, privateNumber, workHours, status, city, truck);
//        driverService.saveDriver(driver);
//        return "redirect:/driversAll";
//    }

    @GetMapping("/newdriver")
    public String newDriver(Model model) {
        model.addAttribute("driver", new Driver());
        return "drivers/newdriver";
    }

}
