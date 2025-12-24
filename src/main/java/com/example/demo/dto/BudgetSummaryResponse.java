package com.example.demo.controller;

public class BudgetSummaryResponse {

    private Double totalBudget;
    private Double totalExpense;
    private Double remainingBudget;

    public BudgetSummaryResponse(Double totalBudget,
                                 Double totalExpense,
                                 Double remainingBudget) {
        this.totalBudget = totalBudget;
        this.totalExpense = totalExpense;
        this.remainingBudget = remainingBudget;
    }

    public Double getTotalBudget() {
        return totalBudget;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public Double getRemainingBudget() {
        return remainingBudget;
    }
}
