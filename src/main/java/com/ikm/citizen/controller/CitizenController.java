package com.ikm.citizen.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.ikm.citizen.model.CitizenModel;
import com.ikm.citizen.service.CitizenService;

@RestController
@RequestMapping("api/v1")
public class CitizenController {
    @Autowired
    CitizenService citizenSer;
    
    @PostMapping("/_create")
    public ResponseEntity<String> CreateCitizen(@RequestBody CitizenModel citizen){
        
        LocalDate dob = citizen.getDateofbirth().toLocalDate();

        if(citizen.getName().equals("")){
            return new ResponseEntity<String>("Name Blank ", HttpStatus.BAD_REQUEST);
        }
        else if(citizen.getAddress().equals("")){
            return new ResponseEntity<String>("Address Blank ", HttpStatus.BAD_REQUEST);
        }
        else if(dob.isAfter(LocalDate.now())){
            return new ResponseEntity<String>("Invalid date ", HttpStatus.BAD_REQUEST);
        }
        else{
            citizenSer.save(citizen);
            return new ResponseEntity<String>("Sucessfully Saved, ID : "+citizen.getId(), HttpStatus.OK);
        }
        
    }
    
}
