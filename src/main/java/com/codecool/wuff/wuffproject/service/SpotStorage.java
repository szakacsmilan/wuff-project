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
    private Spot spot1 = new Spot("1139 Forgach utca", "Nice place with a small puddle for them to swim.", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d13544.408099912756!2d19.07489120720269!3d47.540244471755074!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741dbc10445a70f%3A0x3eebc85bfc68c277!2sBudapest%2C+Forg%C3%A1ch+u.%2C+1139!5e0!3m2!1shu!2shu!4v1554988761330!5m2!1shu!2shu");
    private Spot spot2 = new Spot("1139 Nepfurdo utca", "Beautifull place to chill on the bank of the Danube.", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10779.473329179453!2d19.0658874378662!3d47.51195536882004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741db80afd8e9b1%3A0x757db90f482bea97!2sV%C3%A1rosliget!5e0!3m2!1shu!2shu!4v1554987976042!5m2!1shu!2shu");
    private Spot spot3 = new Spot("1138 Margit-sziget", "The island is mostly covered by landscape parks, and is a popular recreational area.", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10776.405029724661!2d19.039721045808385!3d47.526891616870095!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741dbfc77cfaad7%3A0x689f7bae3aa650fd!2sMargit-sziget!5e0!3m2!1shu!2shu!4v1554995087345!5m2!1shu!2shu");
    private Spot spot4 = new Spot("1101 Népliget", "Beautiful and big area.", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2696.5532939776904!2d19.10653331594367!3d47.47913377917649!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741dcc52f497a2d%3A0xbee033988ae994db!2zTsOpcGxpZ2V0!5e0!3m2!1shu!2shu!4v1554995425166!5m2!1shu!2shu");

    public SpotStorage() {
        spotList.add(spot1);
        spotList.add(spot2);
        spotList.add(spot3);
        spotList.add(spot4);
    }

    public void addSpot(Spot spot) {
        spotList.add(spot);
    }

    public List<Spot> getSpots() {
        return this.spotList;
    }


}
