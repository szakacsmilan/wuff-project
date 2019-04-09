package com.codecool.wuff.wuffproject.controller;

import com.codecool.wuff.wuffproject.model.Spot;
import com.codecool.wuff.wuffproject.service.SpotStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    private SpotStorage spotStorage;

    @GetMapping("/list")
    public List<Spot> spotList() {
        return spotStorage.getSpots();
    }

    @GetMapping("/{id}")
    public Spot spot(@PathVariable("id") int id){
        for(Spot spot: spotStorage.getSpots()){
            if(spot.getId() ==  id){
                return spot;
            }
        }
        return null;
    }
}
