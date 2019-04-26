package com.codecool.wuff.wuffproject.controller;

import com.codecool.wuff.wuffproject.model.Spot;
import com.codecool.wuff.wuffproject.repository.SpotRepository;
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
    private SpotRepository spotRepository;

    @GetMapping("/list")
    public String spotList(Model model) {
        model.addAttribute("spots", spotRepository.findAll());
        return "spotList";
    }

    @GetMapping("/{id}")
    public String spot(@PathVariable("id") int id, Model model){
        Spot currentSpot = null;
        for(Spot spot: spotRepository.findAll()){
            if(spot.getId() ==  id){
                currentSpot = spot;
                break;
            }
        }
        model.addAttribute("spot", currentSpot);
        return "spot";
    }

    @PostMapping("/{id}/comment")
    public String spotComment(@RequestParam("comment") String comment, @PathVariable("id") int id){

        for (Spot spot: spotRepository.findAll()) {
            if(spot.getId() ==  id) {
                spot.addComment(comment);
                spotRepository.save(spot);
                break;
            }
        }
        return "redirect:/spot/{id}";
    }
}
