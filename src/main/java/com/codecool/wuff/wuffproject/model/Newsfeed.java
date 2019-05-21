package com.codecool.wuff.wuffproject.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime birthDate;
    private Long userId;

}
