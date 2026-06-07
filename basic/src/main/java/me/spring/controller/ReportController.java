package me.spring.controller;

import me.spring.service.ReportService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/monthly")
    public Result<?> monthlyReport(@RequestParam int year, @RequestParam int month) {
        return null; // TODO: implement
    }

    @GetMapping("/category-chart")
    public Result<?> categoryPieChart(@RequestParam int year, @RequestParam int month) {
        return null; // TODO: implement
    }

    @GetMapping("/trend-chart")
    public Result<?> trendChart(@RequestParam int year) {
        return null; // TODO: implement
    }

    @GetMapping("/export/excel")
    public Result<?> exportExcel(@RequestParam int year, @RequestParam int month) {
        return null; // TODO: implement
    }

    @GetMapping("/export/pdf")
    public Result<?> exportPdf(@RequestParam int year, @RequestParam int month) {
        return null; // TODO: implement
    }
}
