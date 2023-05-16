package com.loripin.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loripin.fullstackbackend.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
