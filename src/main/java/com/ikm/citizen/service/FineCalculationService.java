package com.ikm.citizen.service;

import org.springframework.stereotype.Service;

import com.ikm.citizen.contract.FineCalculationWrapper;
import com.ikm.citizen.contract.FineGenerationDto;
import com.ikm.citizen.contract.FineGenerationResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class FineCalculationService {
  public FineGenerationResponse generateFine(FineCalculationWrapper request){
    FineGenerationResponse demandResponse = new FineGenerationResponse();

    LocalDate currentDate = LocalDate.now();

    long daysBetween = ChronoUnit.DAYS.between(currentDate, request.getLicenseValidDate());
    double fine = 0.0;
    if (daysBetween < 0) {
      double fineChecker = Double.parseDouble(request.getLicenseFee().toString()) * 3;
      fine = Math.min(fineChecker, 2000.00); // Apply Date is Greater than License Validity To Date 
    } else {
      fine = 0.0;
    }

    double lateFee = 0.0;
    if (daysBetween < 30 && daysBetween >= 0) {
        double lateFeeFirst = Double.parseDouble(request.getLicenseFee().toString()) * 0.10; //Apply Before Valid To Date and After 29 days 10%
        lateFee = lateFeeFirst;
      } else if (daysBetween < 0) {
        double lateFeeFirst = Double.parseDouble(request.getLicenseFee().toString()) * 0.10; //Apply After Valid To Date 10%

        double lateFeeSecond = lateFeeFirst + Double.parseDouble(request.getLicenseFee().toString()) * 0.25; // Calculate First 10 Days 25%

        long additionalLateDays = (-1 * (daysBetween + 10)) / 15; // Calculate additional late days

        lateFeeSecond += additionalLateDays * Double.parseDouble(request.getLicenseFee().toString()) * 0.25; // Calculate Each 15 days - 25%
        if ((-1 * (daysBetween + 10)) % 15 > 0) {
          lateFeeSecond += Double.parseDouble(request.getLicenseFee().toString()) * 0.25;
        }
        lateFee = lateFeeSecond;
      }
      FineGenerationDto fineGenerationDto = FineGenerationDto.builder()
      .fine(BigDecimal.valueOf(fine))
      .lateFee(BigDecimal.valueOf(lateFee))
          .build();
      demandResponse.setFineGeneration(fineGenerationDto);
    return demandResponse;
  }
}
