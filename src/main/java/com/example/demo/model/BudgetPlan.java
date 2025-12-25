package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "budget_plans")
public class BudgetPlan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false)
    private Integer month;
    
    @Column(nullable = false)
    private Integer year;
    
    @Column(nullable = false)
    private Double incomeTarget;
    
    @Column(nullable = false)
    private Double expenseLimit;
    
    // No-arg constructor
    public BudgetPlan() {
    }
    
    // Parameterized constructor: id, user, month, year, incomeTarget, expenseLimit
    public BudgetPlan(Long id, User user, Integer month, Integer year, 
                     Double incomeTarget, Double expenseLimit) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Integer getMonth() {
        return month;
    }
    
    public void setMonth(Integer month) {
        this.month = month;
    }
    
    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public Double getIncomeTarget() {
        return incomeTarget;
    }
    
    public void setIncomeTarget(Double incomeTarget) {
        this.incomeTarget = incomeTarget;
    }
    
    public Double getExpenseLimit() {
        return expenseLimit;
    }
    
    public void setExpenseLimit(Double expenseLimit) {
        this.expenseLimit = expenseLimit;
    }
    
    // Validation method
    public void validate() {
        if (month == null || month < 1 || month > 12) {
            throw new BadRequestException("Month must be between 1 and 12");
        }
        if (incomeTarget != null && incomeTarget < 0) {
            throw new BadRequestException("Income target must be greater than or equal to 0");
        }
        if (expenseLimit != null && expenseLimit < 0) {
            throw new BadRequestException("Expense limit must be greater than or equal to 0");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetPlan that = (BudgetPlan) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}