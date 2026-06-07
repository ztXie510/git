package me.spring.service;

import me.spring.dto.request.TransactionRequest;
import me.spring.dto.response.TransactionResponse;
import me.spring.dto.request.PageRequest;
import me.spring.dto.response.PageResponse;

public interface TransactionService {
    TransactionResponse create(Integer ledgerId, Integer userId, TransactionRequest request);
    TransactionResponse update(Integer id, TransactionRequest request);
    void delete(Integer id);
    TransactionResponse getById(Integer id);
    PageResponse<TransactionResponse> list(Integer ledgerId, PageRequest pageRequest);
}
