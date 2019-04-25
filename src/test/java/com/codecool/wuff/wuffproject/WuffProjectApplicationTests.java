package com.codecool.wuff.wuffproject;

import com.codecool.wuff.wuffproject.model.Spot;
import com.codecool.wuff.wuffproject.repository.SpotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WuffProjectApplicationTests {

    @Autowired
    private SpotRepository spotRepository;

    @Test
    public void testAddNewSpot(){
        Spot spot = Spot.builder()
                .address("Vauuu")
                .description("kiskutya")
                .build();

        spotRepository.save(spot);

        assertThat(spotRepository.findAll())
                .hasSize(5);
    }


    @Test
    public void testAddNewComment(){

        for (Spot spot: spotRepository.findAll()) {
            if(spot.getId() == 1){
                spot.addComment("vauvau");
                spotRepository.save(spot);
            }
        }



        assertThat(spotRepository.findAll().get(0).getComments()).hasSize(1);
    }

}
