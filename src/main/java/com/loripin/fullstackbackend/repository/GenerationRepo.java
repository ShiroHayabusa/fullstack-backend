package com.loripin.fullstackbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Generation;

public interface GenerationRepo extends JpaRepository<Generation, Long>{
    List<Generation> findByMakeNameAndModelName(String namemake, String name);
    
}
