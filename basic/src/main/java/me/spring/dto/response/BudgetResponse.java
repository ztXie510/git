package me.spring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetResponse {
    private Integer id;
    private BigDecimal amount;
    private BigDecimal spent;
    private BigDecimal remaining;
    private double percentage;
    private String status;
    private String categoryName;
    private Integer categoryId;
    private String periodType;
}
