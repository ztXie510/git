package me.spring.service;

import me.spring.dto.request.BillRequest;
import me.spring.dto.response.BillResponse;

import java.util.List;

public interface BillService {
    BillResponse create(Integer ledgerId, BillRequest request);
    BillResponse update(Integer id, BillRequest request);
    void delete(Integer id);
    BillResponse getById(Integer id);
    List<BillResponse> listByLedger(Integer ledgerId);
    BillResponse markAsPaid(Integer id);
    List<BillResponse> getOverdue(Integer ledgerId);
}
