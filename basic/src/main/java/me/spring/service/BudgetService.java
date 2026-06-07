package me.spring.service;

import me.spring.dto.request.BudgetRequest;
import me.spring.dto.response.BudgetResponse;

import java.util.List;

public interface BudgetService {
    BudgetResponse create(Integer ledgerId, BudgetRequest request);
    BudgetResponse update(Integer id, BudgetRequest request);
    void delete(Integer id);
    BudgetResponse getById(Integer id);
    List<BudgetResponse> listByLedger(Integer ledgerId);
    List<BudgetResponse> checkAlerts(Integer ledgerId);
}
