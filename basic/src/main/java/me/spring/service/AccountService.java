package me.spring.service;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    AccountService.AccountDto create(Integer ledgerId, String name, String type);
    AccountService.AccountDto update(Integer id, String name, BigDecimal balance);
    void delete(Integer id);
    List<AccountService.AccountDto> listByLedger(Integer ledgerId);

    @lombok.Data
    @lombok.AllArgsConstructor
    class AccountDto {
        private Integer id;
        private String name;
        private String type;
        private BigDecimal balance;
        private String currency;
        private Boolean isActive;
    }
}
