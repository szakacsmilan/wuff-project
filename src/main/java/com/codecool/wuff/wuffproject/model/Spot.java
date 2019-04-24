package com.codecool.wuff.wuffproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Spot {

    @Id
    @GeneratedValue
    private Long id;

    private String address;
    private String description;
    private String map;
    private Long likeNum;
//    private List<String> comments = new ArrayList<>();

}
