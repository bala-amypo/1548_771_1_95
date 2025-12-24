package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {

    BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);

    // 🔥 ADD THIS
    BudgetPlan getBudgetPlan(Long userId, int month, int year);
}
