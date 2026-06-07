package me.spring.service;

import me.spring.dto.response.ReportResponse;
import me.spring.vo.ChartDataVO;
import me.spring.vo.ExportFileVO;

public interface ReportService {
    ReportResponse monthlyReport(Integer ledgerId, int year, int month);
    ChartDataVO categoryPieChart(Integer ledgerId, int year, int month);
    ChartDataVO trendChart(Integer ledgerId, int year);
    ExportFileVO exportExcel(Integer ledgerId, int year, int month);
    ExportFileVO exportPdf(Integer ledgerId, int year, int month);
}
