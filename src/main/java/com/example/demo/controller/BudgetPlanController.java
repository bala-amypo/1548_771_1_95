// package com.example.demo3.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo3.model.BudgetPlan;
// import com.example.demo3.service.BudgetPlanService;

// @RestController
// @RequestMapping("/budgets")
// public class BudgetPlanController {

//     @Autowired
//     private BudgetPlanService service;

//     @PostMapping("/{userId}")
//     public BudgetPlan create(@PathVariable Long userId,
//                              @RequestBody BudgetPlan plan) {
//         return service.createBudgetPlan(userId, plan);
//     }

//     @GetMapping("/{userId}/{month}/{year}")
//     public BudgetPlan get(@PathVariable Long userId,
//                           @PathVariable Integer month,
//                           @PathVariable Integer year) {
//         return service.getBudgetPlan(userId, month, year);
//     }
// }









