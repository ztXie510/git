package me.spring.controller;

import me.spring.service.BillService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public Result<?> create(@RequestBody Object request) { return null; }

    @GetMapping
    public Result<?> list() { return null; }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Integer id) { return null; }

    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Integer id, @RequestBody Object request) { return null; }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) { return null; }

    @PutMapping("/{id}/pay")
    public Result<?> markAsPaid(@PathVariable Integer id) { return null; }

    @GetMapping("/overdue")
    public Result<?> getOverdue() { return null; }
}
