package com.loripin.fullstackbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Facelift;

public interface FaceliftRepo extends JpaRepository<Facelift, Long> {
    List<Facelift> findByGenerationId(Long generation);
}
