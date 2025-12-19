// package com.example.demo3.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo3.model.BudgetPlan;
// import com.example.demo3.model.User;
// import com.example.demo3.repository.BudgetPlanRepository;
// import com.example.demo3.repository.UserRepository;
// import com.example.demo3.service.BudgetPlanService;

// @Service
// public class BudgetPlanServiceImpl implements BudgetPlanService {

//     @Autowired
//     private BudgetPlanRepository budgetRepo;

//     @Autowired
//     private UserRepository userRepo;

//     @Override
//     public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {

//         if (plan.getMonth() < 1 || plan.getMonth() > 12) {
//             throw new RuntimeException("Invalid month");
//         }

//         User user = userRepo.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         plan.setUser(user);
//         return budgetRepo.save(plan);
//     }

//     @Override
//     public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {
//         return budgetRepo.findByUserIdAndMonthAndYear(userId, month, year)
//                 .orElseThrow(() -> new RuntimeException("Budget plan not found"));
//     }
// }
