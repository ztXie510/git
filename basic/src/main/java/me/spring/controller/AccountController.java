package me.spring.controller;

import me.spring.service.AccountService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Result<?> create(@RequestBody Object request) { return null; }

    @GetMapping
    public Result<?> list() { return null; }

    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Integer id, @RequestBody Object request) { return null; }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) { return null; }
}
