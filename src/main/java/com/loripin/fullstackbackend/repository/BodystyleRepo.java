package com.loripin.fullstackbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Bodystyle;

public interface BodystyleRepo extends JpaRepository<Bodystyle, Long>{
   List<Bodystyle> findByFaceliftId(Long facelift);
    
}
