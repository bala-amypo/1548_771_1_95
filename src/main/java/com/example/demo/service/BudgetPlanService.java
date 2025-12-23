
// // package com.example.demo.service;

// // import com.example.demo.model.BudgetPlan;

// // public interface BudgetPlanService {

// //     BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);

// //     BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
// // }
// // package com.example.demo.service;

// // import com.example.demo.model.BudgetPlan;

// // public interface BudgetPlanService {

// //     BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);

// //     BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
// // }

// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.BudgetPlan;

// public interface BudgetPlanService {

//     BudgetPlan create(BudgetPlan plan);

//     List<BudgetPlan> getAll();

//     BudgetPlan getById(Long id);

//     BudgetPlan update(Long id, BudgetPlan plan);

//     void delete(Long id);
// }
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {

    BudgetPlan createBudgetPlan(Long userId, BudgetPlan budgetPlan);

    List<BudgetPlan> getBudgetPlans(Long userId, Integer year, Integer month);
}

