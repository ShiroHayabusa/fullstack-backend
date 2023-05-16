package com.loripin.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Make;

public interface MakeRepo extends JpaRepository<Make, Long>{
    
}
