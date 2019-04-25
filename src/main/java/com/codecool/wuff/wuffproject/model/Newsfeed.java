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
public class Newsfeed {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

}
