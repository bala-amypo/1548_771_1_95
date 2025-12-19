package com.example.demo4.service;

import com.example.demo4.model.BudgetSummary;

public interface BudgetSummaryService {

    BudgetSummary generateSummary(Long budgetPlanId);

    BudgetSummary getSummary(Long budgetPlanId);
}

