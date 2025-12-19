// package com.example.demo3.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo3.model.BudgetPlan;
// import com.example.demo3.model.BudgetSummary;
// import com.example.demo3.repository.BudgetPlanRepository;
// import com.example.demo3.repository.BudgetSummaryRepository;
// import com.example.demo3.service.BudgetSummaryService;

// @Service
// public class BudgetSummaryServiceImpl implements BudgetSummaryService {

//     @Autowired
//     private BudgetSummaryRepository summaryRepo;

//     @Autowired
//     private BudgetPlanRepository budgetRepo;

//     @Override
//     public BudgetSummary generateSummary(Long budgetPlanId) {

//         BudgetPlan plan = budgetRepo.findById(budgetPlanId)
//                 .orElseThrow(() -> new RuntimeException("Budget plan not found"));

//         BudgetSummary summary = new BudgetSummary();
//         summary.setBudgetPlan(plan);

//         double totalIncome = plan.getIncomeTarget();
//         double totalExpense = plan.getExpenseLimit();

//         summary.setTotalIncome(totalIncome);
//         summary.setTotalExpense(totalExpense);

//         if (totalExpense <= plan.getExpenseLimit()) {
//             summary.setStatus("UNDER_LIMIT");
//         } else {
//             summary.setStatus("OVER_LIMIT");
//         }

//         return summaryRepo.save(summary);
//     }

//     @Override
//     public BudgetSummary getSummary(Long budgetPlanId) {
//         return summaryRepo.findByBudgetPlanId(budgetPlanId)
//                 .orElseThrow(() -> new RuntimeException("Summary not found"));
//     }
// }

