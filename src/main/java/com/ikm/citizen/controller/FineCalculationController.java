package com.ikm.citizen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikm.citizen.service.FineCalculationService;

import lombok.RequiredArgsConstructor;

import com.ikm.citizen.contract.FineGenerationResponse;
import com.ikm.citizen.contract.Response;
import com.ikm.citizen.contract.FineCalculationWrapper;

@RestController
@RequestMapping("/calculation")
@RequiredArgsConstructor
public class FineCalculationController {
  @Autowired
  FineCalculationService FineService;
  
  @PostMapping("/fine-calculation")
  public ResponseEntity<Response<FineGenerationResponse>> GetFineCalculation(
      @RequestBody FineCalculationWrapper request) {
    FineGenerationResponse fineResponse =  FineService.generateFine(request);
      
        return new ResponseEntity<>(
                Response.<FineGenerationResponse>builder()
                        .payload(fineResponse)
                        .message("Success")
                        .build(),
                HttpStatus.OK);
  }
}
