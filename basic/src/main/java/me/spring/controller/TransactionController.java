package me.spring.controller;

import me.spring.service.TransactionService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Result<?> create(@RequestBody Object request) { return null; }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Integer id) { return null; }

    @GetMapping
    public Result<?> list(@RequestParam(required = false) Object filter) { return null; }

    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Integer id, @RequestBody Object request) { return null; }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) { return null; }
}
