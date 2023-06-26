package com.ikm.citizen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikm.citizen.model.CitizenModel;
import com.ikm.citizen.repository.CitizenRepository;

@Service
public class CitizenService {
    @Autowired
    CitizenRepository citizenRepo;

    public CitizenModel save(CitizenModel citizenM){
       return  citizenRepo.save(citizenM);
    }
    
}
