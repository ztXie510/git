package me.spring.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BillRequest {
    @NotBlank
    private String name;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    @NotNull
    private LocalDate dueDate;

    @NotBlank
    private String billType;

    private Integer accountId;
    private Integer remindBefore;
    private String repeatType;
}
