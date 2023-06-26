package com.ikm.citizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikm.citizen.model.CitizenModel;

@Repository
public interface CitizenRepository extends JpaRepository<CitizenModel, Long> {
    
}
