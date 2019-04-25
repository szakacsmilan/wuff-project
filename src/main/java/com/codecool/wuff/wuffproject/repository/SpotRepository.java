package com.codecool.wuff.wuffproject.repository;

import com.codecool.wuff.wuffproject.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {


}
