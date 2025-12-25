package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "budget_summaries")
public class BudgetSummary {
    
    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
    public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_plan_id", nullable = false, unique = true)
    private BudgetPlan budgetPlan;
    
    @Column(nullable = false)
    private Double totalIncome;
    
    @Column(nullable = false)
    private Double totalExpense;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private LocalDateTime generatedAt;
    
    // No-arg constructor
    public BudgetSummary() {
    }
    
    // Parameterized constructor: id, budgetPlan, totalIncome, totalExpense, status, generatedAt
    public BudgetSummary(Long id, BudgetPlan budgetPlan, Double totalIncome, 
                        Double totalExpense, String status, LocalDateTime generatedAt) {
        this.id = id;
        this.budgetPlan = budgetPlan;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.status = status;
        this.generatedAt = generatedAt;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BudgetPlan getBudgetPlan() {
        return budgetPlan;
    }
    
    public void setBudgetPlan(BudgetPlan budgetPlan) {
        this.budgetPlan = budgetPlan;
    }
    
    public Double getTotalIncome() {
        return totalIncome;
    }
    
    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }
    
    public Double getTotalExpense() {
        return totalExpense;
    }
    
    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
    
    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
    
    // Lifecycle callback
    @PrePersist
    public void onCreate() {
        if (this.generatedAt == null) {
            this.generatedAt = LocalDateTime.now();
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetSummary that = (BudgetSummary) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}