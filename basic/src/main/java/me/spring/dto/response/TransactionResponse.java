package me.spring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Integer id;
    private String type;
    private BigDecimal amount;
    private String categoryName;
    private Integer categoryId;
    private String accountName;
    private Integer accountId;
    private LocalDateTime transactionDate;
    private String description;
    private List<String> tags;
    private String createdBy;
    private LocalDateTime createdAt;
}
