package me.spring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillResponse {
    private Integer id;
    private String name;
    private BigDecimal amount;
    private LocalDate dueDate;
    private String billType;
    private String status;
    private String accountName;
    private Integer remindBefore;
    private String repeatType;
    private LocalDateTime paidAt;
    private boolean isOverdue;
    private long daysUntilDue;
}
