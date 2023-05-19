package com.loripin.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Model;

public interface ModelRepo extends JpaRepository<Model, Long>{
    
}
