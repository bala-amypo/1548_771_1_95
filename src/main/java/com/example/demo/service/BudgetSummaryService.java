// // package com.example.demo.service;

// // import com.example.demo.model.BudgetSummary;

// // public interface BudgetSummaryService {

// //     BudgetSummary generateSummary(Long budgetPlanId);

// //     BudgetSummary getSummary(Long budgetPlanId);
// // }

// package com.example.demo.service;

// import com.example.demo.model.BudgetSummary;

// public interface BudgetSummaryService {

//     BudgetSummary generateSummary(Long budgetPlanId);

//     BudgetSummary getSummary(Long budgetPlanId);
// }

package com.example.demo.service;

public interface BudgetSummaryService {

    Double getTotalBudget(Long userId, Integer year, Integer month);

    Double getTotalExpense(Long userId, Integer year, Integer month);

    Double getRemainingBudget(Long userId, Integer year, Integer month);
}
