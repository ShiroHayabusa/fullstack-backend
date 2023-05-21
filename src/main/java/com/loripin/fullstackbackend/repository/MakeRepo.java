package com.loripin.fullstackbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Make;

public interface MakeRepo extends JpaRepository<Make, Long>{

    Make findByName(String name);
    List<Make> findAllByOrderByNameAsc();
    
}
