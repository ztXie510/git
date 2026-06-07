package me.spring.service;

import java.util.List;

public interface TagService {
    TagService.TagDto create(Integer ledgerId, String name, String color);
    TagService.TagDto update(Integer id, String name, String color);
    void delete(Integer id);
    List<TagService.TagDto> listByLedger(Integer ledgerId);

    @lombok.Data
    @lombok.AllArgsConstructor
    class TagDto {
        private Integer id;
        private String name;
        private String color;
    }
}
