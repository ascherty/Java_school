package com.dtlogistics.controllers;

import com.dtlogistics.dto.TruckDTO;
import com.dtlogistics.models.Driver;
import com.dtlogistics.models.Truck;
import com.dtlogistics.services.TruckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trucks")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping()
    public String trucksAll(Model model) {
        model.addAttribute("trucks", truckService.findAllTrucks());
        return "trucks/trucksAll";
    }

    @GetMapping("/{id}")
    public String truckDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("truck", truckService.findTruck(id));
        return "trucks/truckDetails";
    }

    @PutMapping("/trucks/")
    public String updateTruck(@ModelAttribute("truck") TruckDTO truckDto) {
        truckService.updateTruck(truckDto);
        return "trucks/truckDetails";
    }

    @PostMapping()
    public String saveTruck(@ModelAttribute("truck") TruckDTO truckDto) {
        truckService.saveTruck(truckDto);
        return "redirect:trucks";
    }

//    @PostMapping("/{id}")
//    public String deleteTruck(@PathVariable("id") int id, TruckDTO truckDto) {
//        truckService.deleteTruck(truckDto);
//        return "redirect:trucks";
//    }

    @DeleteMapping("/{id}")
    public String deleteTruck(@PathVariable("id") int id, TruckDTO truckDto){
        truckService.deleteTruck(truckService.findTruck(id));
        return "redirect:trucks";
    }

//    @DeleteMapping("/delete")
//    public String deleteTruck(@RequestParam(value="id") TruckDTO truckDto){
//        truckService.deleteTruck(truckDto);
//        return "redirect:trucks";
//    }

}
