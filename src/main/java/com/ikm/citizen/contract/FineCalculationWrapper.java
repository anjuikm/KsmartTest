package com.ikm.citizen.contract;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FineCalculationWrapper {
  private BigDecimal licenseFee;
  private String applicationType;
  private LocalDate renewalDateTo;
}
