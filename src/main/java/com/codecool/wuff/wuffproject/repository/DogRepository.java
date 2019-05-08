package com.codecool.wuff.wuffproject.repository;

import com.codecool.wuff.wuffproject.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository <Dog, Long> {
}
