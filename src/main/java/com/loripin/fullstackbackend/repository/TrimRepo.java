package com.loripin.fullstackbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Trim;

public interface TrimRepo extends JpaRepository<Trim, Long> {
    List<Trim> findByBodystyleId(Long bodystyle);
}
