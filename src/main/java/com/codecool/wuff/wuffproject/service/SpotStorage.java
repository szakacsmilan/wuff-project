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
    private Spot spot1 = new Spot("1139 Forgach utca", "Nice place with a small puddle for them to swim.");
    private Spot spot2 = new Spot("1139 Nepfurdo utca", "Beautifull place to chill on the bank of the Danube.");

    public SpotStorage() {
        spotList.add(spot1);
        spotList.add(spot2);

    }

    public void addSpot(Spot spot) {
        spotList.add(spot);
    }


    public List<Spot> getSpots() {
        return this.spotList;
    }


}
