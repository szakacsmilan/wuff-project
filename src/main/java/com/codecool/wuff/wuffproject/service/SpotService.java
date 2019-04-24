package com.codecool.wuff.wuffproject.service;

import com.codecool.wuff.wuffproject.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotService {

    private SpotRepository spotRepository;

    @Autowired
    public  void setSpotRepository(SpotRepository spotRepository){
        this.spotRepository = spotRepository;
    }

}
