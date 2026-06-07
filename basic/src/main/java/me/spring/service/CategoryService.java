package me.spring.service;

import java.util.List;

public interface CategoryService {
    CategoryService.CategoryDto create(Integer ledgerId, String name, String type, Integer parentId);
    CategoryService.CategoryDto update(Integer id, String name, String icon, String color);
    void delete(Integer id);
    List<CategoryService.CategoryDto> getByType(Integer ledgerId, String type);
    List<CategoryService.CategoryDto> listByLedger(Integer ledgerId);

    @lombok.Data
    @lombok.AllArgsConstructor
    class CategoryDto {
        private Integer id;
        private String name;
        private String type;
        private String icon;
        private String color;
        private Integer parentId;
    }
}
