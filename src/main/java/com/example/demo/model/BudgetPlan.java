// package com.example.demo3.model;

// import org.springframework.data.annotation.Id;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;

// @Entity
// @Table(name = "budget_plans",
//        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "month", "year"}))

// public class BudgetPlan {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     @Column(nullable = false)
//     private Integer month; 

//     @Column(nullable = false)
//     private Integer year;
//     private Double incomeTarget;
//     private Double expenseLimit;

//     public BudgetPlan(){

//     }

//     public BudgetPlan(User user, Integer month, Integer year, Double incomeTarget, Double expenseLimit) {
//         this.user = user;
//         this.month = month;
//         this.year = year;
//         this.incomeTarget = incomeTarget;
//         this.expenseLimit = expenseLimit;
//     }

//     public Long getId() {
//         return id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public Integer getMonth() {
//         return month;
//     }

//     public Integer getYear() {
//         return year;
//     }

//     public Double getIncomeTarget() {
//         return incomeTarget;
//     }

//     public Double getExpenseLimit() {
//         return expenseLimit;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public void setMonth(Integer month) {
//         this.month = month;
//     }

//     public void setYear(Integer year) {
//         this.year = year;
//     }

//     public void setIncomeTarget(Double incomeTarget) {
//         this.incomeTarget = incomeTarget;
//     }

//     public void setExpenseLimit(Double expenseLimit) {
//         this.expenseLimit = expenseLimit;
//     }
    



// }





package com.example.demo4.model;

import org.springframework.data.annotation.Id;

import com.example.demo4.exception.BadRequestException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "budget_plans",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"user_id", "month", "year"})
       })
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Integer month;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Double incomeTarget;

    @Column(nullable = false)
    private Double expenseLimit;

    public BudgetPlan() {
    }

    public BudgetPlan(
            Long id,
            User user,
            Integer month,
            Integer year,
            Double incomeTarget,
            Double expenseLimit
    ) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
    }

    public void validate() {
        if (month == null || month < 1 || month > 12) {
            throw new BadRequestException("Month must be between 1 and 12");
        }

        if (incomeTarget == null || incomeTarget < 0) {
            throw new BadRequestException("Income target must be >= 0");
        }

        if (expenseLimit == null || expenseLimit < 0) {
            throw new BadRequestException("Expense limit must be >= 0");
        }
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public Double getIncomeTarget() {
        return incomeTarget;
    }

    public Double getExpenseLimit() {
        return expenseLimit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setIncomeTarget(Double incomeTarget) {
        this.incomeTarget = incomeTarget;
    }

    public void setExpenseLimit(Double expenseLimit) {
        this.expenseLimit = expenseLimit;
    }
}

