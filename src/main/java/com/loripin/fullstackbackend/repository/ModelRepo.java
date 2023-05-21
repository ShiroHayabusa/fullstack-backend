package com.loripin.fullstackbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.Model;

public interface ModelRepo extends JpaRepository<Model, Long>{
    List<Model> findByMakeNameOrderByName(String name);
    Model findByName(String name);
}
