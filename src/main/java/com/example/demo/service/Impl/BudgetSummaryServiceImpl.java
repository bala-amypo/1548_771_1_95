package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BudgetSummaryService;

public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository txRepo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepo,
                                    BudgetPlanRepository planRepo,
                                    TransactionLogRepository txRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.txRepo = txRepo;
    }

    public BudgetSummary generateSummary(Long budgetPlanId) {
        return null;
    }

    public BudgetSummary getSummary(Long budgetPlanId) {
        return null;
    }
}
