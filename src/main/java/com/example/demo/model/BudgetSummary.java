// package com.example.demo3.model;

// import java.time.LocalDateTime;

// import org.springframework.data.annotation.Id;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "budget_summaries")
// public class BudgetSummary {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "budget_plan_id", nullable = false)
//     private BudgetPlan budgetPlan;

//     private Double totalIncome;

//     private Double totalExpense;

//     private String status; 

//     private LocalDateTime generatedAt;
    
//     public BudgetSummary(){

//     }

//     public BudgetSummary(BudgetPlan budgetPlan, Double totalIncome, Double totalExpense, String status,
//             LocalDateTime generatedAt) {
//         this.budgetPlan = budgetPlan;
//         this.totalIncome = totalIncome;
//         this.totalExpense = totalExpense;
//         this.status = status;
//         this.generatedAt = generatedAt;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public BudgetPlan getBudgetPlan() {
//         return budgetPlan;
//     }

//     public void setBudgetPlan(BudgetPlan budgetPlan) {
//         this.budgetPlan = budgetPlan;
//     }

//     public Double getTotalIncome() {
//         return totalIncome;
//     }

//     public void setTotalIncome(Double totalIncome) {
//         this.totalIncome = totalIncome;
//     }

//     public Double getTotalExpense() {
//         return totalExpense;
//     }

//     public void setTotalExpense(Double totalExpense) {
//         this.totalExpense = totalExpense;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public LocalDateTime getGeneratedAt() {
//         return generatedAt;
//     }

//     public void setGeneratedAt(LocalDateTime generatedAt) {
//         this.generatedAt = generatedAt;
//     }
// }


package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Entity
@Table(name = "budget_summaries")
public class BudgetSummary {

    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
    public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "budget_plan_id", unique = true)
    private BudgetPlan budgetPlan;

    @Column(nullable = false)
    private Double totalIncome;

    @Column(nullable = false)
    private Double totalExpense;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime generatedAt;

    public BudgetSummary() {
    }

    public BudgetSummary(
            Long id,
            BudgetPlan budgetPlan,
            Double totalIncome,
            Double totalExpense,
            String status,
            LocalDateTime generatedAt
    ) {
        this.id = id;
        this.budgetPlan = budgetPlan;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.status = status;
        this.generatedAt = generatedAt;
    }

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public BudgetPlan getBudgetPlan() {
        return budgetPlan;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBudgetPlan(BudgetPlan budgetPlan) {
        this.budgetPlan = budgetPlan;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

