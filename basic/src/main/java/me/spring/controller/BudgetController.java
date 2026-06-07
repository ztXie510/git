package me.spring.controller;

import me.spring.service.BudgetService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public Result<?> create(@RequestBody Object request) { return null; }

    @GetMapping
    public Result<?> list() { return null; }

    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Integer id, @RequestBody Object request) { return null; }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) { return null; }

    @GetMapping("/alerts")
    public Result<?> getAlerts() { return null; }
}
