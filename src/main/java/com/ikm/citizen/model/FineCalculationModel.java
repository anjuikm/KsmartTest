package com.ikm.citizen.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FineCalculationModel {
   private BigDecimal licenseFee;
   private String applicationType;
  
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate validFrom;
}
