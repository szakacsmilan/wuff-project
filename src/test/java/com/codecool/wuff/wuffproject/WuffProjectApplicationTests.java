package com.codecool.wuff.wuffproject;

import com.codecool.wuff.wuffproject.model.Dog;
import com.codecool.wuff.wuffproject.model.Newsfeed;
import com.codecool.wuff.wuffproject.model.Spot;
import com.codecool.wuff.wuffproject.repository.DogRepository;
import com.codecool.wuff.wuffproject.repository.NewsFeedRepository;
import com.codecool.wuff.wuffproject.repository.SpotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WuffProjectApplicationTests {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private NewsFeedRepository newsFeedRepository;

    @Test
    public void testAddSpot(){
        Spot spot = Spot.builder()
                .address("Vauuu")
                .description("kiskutya")
                .build();

        spotRepository.save(spot);

        assertThat(spotRepository.findAll())
                .hasSize(5);
    }


    @Test
    public void testAddCommentToSpot(){

        for (Spot spot: spotRepository.findAll()) {
            if(spot.getId() == 1){
                spot.addComment("vauvau");
                spotRepository.save(spot);
            }
        }



        assertThat(spotRepository.findAll().get(0).getComments()).hasSize(1);
    }

    @Test
    public void testAddFeed(){
        Newsfeed newsfeed = Newsfeed.builder()
                .comment("asd")
                .birthDate(LocalDateTime.now())
                .build();

        newsFeedRepository.save(newsfeed);
        assertThat(newsFeedRepository.findAll()).hasSize(3);

    }


    @Test
    public void testAddDog(){
        Dog lajos = Dog.builder()
                .ownerName("Lajos")
                .build();

        dogRepository.save(lajos);
        assertThat(dogRepository.findAll()).hasSize(1);
    }
}
