package com.codecool.wuff.wuffproject.controller;

import com.codecool.wuff.wuffproject.model.Spot;
import com.codecool.wuff.wuffproject.service.SpotStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    private SpotStorage spotStorage;

    @GetMapping("/list")
    public String spotList(Model model) {
        model.addAttribute("spots", spotStorage.getSpots());
        return "spotList";
    }

    @GetMapping("/{id}")
    public String spot(@PathVariable("id") int id, Model model){
        Spot currentSpot = null;
        for(Spot spot: spotStorage.getSpots()){
            if(spot.getId() ==  id){
                currentSpot = spot;
                break;
            }
        }
        model.addAttribute("spot", currentSpot);
        return "spot";
    }
}
