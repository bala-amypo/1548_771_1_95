// package com.example.demo3.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo3.model.BudgetSummary;
// import com.example.demo3.service.BudgetSummaryService;

// @RestController
// @RequestMapping("/summary")
// public class BudgetSummaryController {

//     @Autowired
//     private BudgetSummaryService service;

//     @PostMapping("/{budgetPlanId}")
//     public BudgetSummary generate(@PathVariable Long budgetPlanId) {
//         return service.generateSummary(budgetPlanId);
//     }

//     @GetMapping("/{budgetPlanId}")
//     public BudgetSummary get(@PathVariable Long budgetPlanId) {
//         return service.getSummary(budgetPlanId);
//     }
// }


