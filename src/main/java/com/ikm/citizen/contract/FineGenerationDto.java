package com.ikm.citizen.contract;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FineGenerationDto {
  private BigDecimal fine;
  private BigDecimal lateFee;
}
