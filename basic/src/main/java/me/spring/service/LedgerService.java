package me.spring.service;

import java.util.List;

public interface LedgerService {
    LedgerService.LedgerDto create(Integer userId, String name, String description);
    LedgerService.LedgerDto update(Integer id, String name, String description);
    void delete(Integer id);
    LedgerService.LedgerDto getById(Integer id);
    List<LedgerService.LedgerDto> listByUser(Integer userId);

    @lombok.Data
    @lombok.AllArgsConstructor
    class LedgerDto {
        private Integer id;
        private String name;
        private String description;
        private Integer memberCount;
        private Boolean isDefault;
    }
}
