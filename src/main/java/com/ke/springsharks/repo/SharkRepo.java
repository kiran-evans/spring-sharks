package com.ke.springsharks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ke.springsharks.entity.Shark;

@Repository
public interface SharkRepo extends JpaRepository<Shark, Long>{

}