package me.spring.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TransactionRequest {
    @NotBlank
    private String type;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Integer accountId;

    @NotNull
    private LocalDateTime transactionDate;

    private String description;
    private List<Integer> tagIds;
}
