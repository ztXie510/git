package me.spring.controller;

import me.spring.service.CategoryService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Result<?> create(@RequestBody Object request) { return null; }

    @GetMapping
    public Result<?> list(@RequestParam(required = false) String type) { return null; }

    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Integer id, @RequestBody Object request) { return null; }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) { return null; }
}
