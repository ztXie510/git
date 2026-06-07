package me.spring.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class BudgetRequest {
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    private Integer categoryId;

    @NotNull
    private String periodType;
}
