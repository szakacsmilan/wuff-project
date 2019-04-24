package com.codecool.wuff.wuffproject;

import com.codecool.wuff.wuffproject.model.Spot;
import com.codecool.wuff.wuffproject.repository.SpotRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class WuffProjectApplication{

    @Autowired
    private SpotRepository spotRepository;

    public static void main(String[] args) {
        SpringApplication.run(WuffProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Spot spot1 = Spot.builder()
                    .address("1139 Forgach utca")
                    .description("Nice place with a small puddle for them to swim.")
                    //.map("2693.483737925008!2d19.071865615945285!3d47.53891317918025!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741dbc10445a70f%3A0x3eebc85bfc68c277!2sBudapest%2C+Forg%C3%A1ch+u.%2C+1139!5e0!3m2!1shu!2shu!4v1556090216887!5m2!1shu!2shu\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>")
                    .build();

            Spot spot2 = Spot.builder()
                    .address("1139 Nepfurdo utca")
                    .description("Beautifull place to chill on the bank of the Danube.")
                    //.map("10779.473329179453!2d19.0658874378662!3d47.51195536882004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741db80afd8e9b1%3A0x757db90f482bea97!2sV%C3%A1rosliget!5e0!3m2!1shu!2shu!4v1554987976042!5m2!1shu!2shu")
                    .build();

            Spot spot3 = Spot.builder()
                    .address("1138 Margit-sziget")
                    .description("The island is mostly covered by landscape parks, and is a popular recreational area.")
                    //.map("10776.405029724661!2d19.039721045808385!3d47.526891616870095!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741dbfc77cfaad7%3A0x689f7bae3aa650fd!2sMargit-sziget!5e0!3m2!1shu!2shu!4v1554995087345!5m2!1shu!2shu")
                    .build();

            Spot spot4 = Spot.builder()
                    .address("1101 Népliget")
                    .description("Beautiful and big area.")
                    //.map("2696.5532939776904!2d19.10653331594367!3d47.47913377917649!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4741dcc52f497a2d%3A0xbee033988ae994db!2zTsOpcGxpZ2V0!5e0!3m2!1shu!2shu!4v1554995425166!5m2!1shu!2shu")
                    .build();

            spotRepository.saveAll(Lists.newArrayList(spot1, spot2, spot3, spot4));


        };
    }


}
