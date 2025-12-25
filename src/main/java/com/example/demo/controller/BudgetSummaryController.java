package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/summary")
public class BudgetSummaryController {
    private final BudgetSummaryService budgetSummaryService;

    public BudgetSummaryController(BudgetSummaryService budgetSummaryService) {
        this.budgetSummaryService = budgetSummaryService;
    }

    @PostMapping("/generate/{budgetPlanId}")
    public ResponseEntity<BudgetSummary> generateSummary(@PathVariable Long budgetPlanId) {
        return ResponseEntity.ok(budgetSummaryService.generateSummary(budgetPlanId));
    }

    @GetMapping("/{budgetPlanId}")
    public ResponseEntity<BudgetSummary> getSummary(@PathVariable Long budgetPlanId) {
        return ResponseEntity.ok(budgetSummaryService.getSummary(budgetPlanId));
    }
}