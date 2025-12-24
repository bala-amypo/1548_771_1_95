package com.example.demo.service;

import com.example.demo.dto.BudgetSummaryResponse;

public interface BudgetSummaryService {
    BudgetSummaryResponse getSummary(Long userId, int month, int year);
}
