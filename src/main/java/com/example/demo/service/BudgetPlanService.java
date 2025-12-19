// package com.example.demo3.service;

// import com.example.demo3.model.BudgetPlan;

// public interface BudgetPlanService {

//     BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);
//     BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
// }





package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {

    BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);

    BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
}
