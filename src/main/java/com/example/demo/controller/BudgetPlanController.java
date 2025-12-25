package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {
    private final BudgetPlanService budgetPlanService;

    public BudgetPlanController(BudgetPlanService budgetPlanService) {
        this.budgetPlanService = budgetPlanService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<BudgetPlan> createBudgetPlan(@PathVariable Long userId, 
                                                      @RequestBody BudgetPlan plan) {
        return ResponseEntity.ok(budgetPlanService.createBudgetPlan(userId, plan));
    }

    @GetMapping("/{userId}/{month}/{year}")
    public ResponseEntity<BudgetPlan> getBudgetPlan(@PathVariable Long userId,
                                                    @PathVariable Integer month,
                                                    @PathVariable Integer year) {
        return ResponseEntity.ok(budgetPlanService.getBudgetPlan(userId, month, year));
    }
}
