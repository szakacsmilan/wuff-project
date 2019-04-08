package com.codecool.wuff.wuffproject.service;

import com.codecool.wuff.wuffproject.model.Spot;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class SpotStorage {

    private List<Spot> spotList = new LinkedList<>();


    public SpotStorage() {
    }

    public void addSpot(Spot spot) {
        spotList.add(spot);
    }


    public List<Spot> getSpots() {
        return this.spotList;
    }


}
