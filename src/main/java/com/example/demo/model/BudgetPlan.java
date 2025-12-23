
// package com.example.demo.model;

// import com.example.demo.exception.BadRequestException;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "budget_plans")
// public class BudgetPlan {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private Integer month;

//     @Column(nullable = false)
//     private Integer year;

//     @Column(nullable = false)
//     private Double expenseLimit;

//     @ManyToOne(optional = false)
//     @JoinColumn(name = "user_id")
//     private User user;


//     public BudgetPlan() {
//     }

//     public BudgetPlan(Integer month, Integer year, Double expenseLimit, User user) {
//         this.month = month;
//         this.year = year;
//         this.expenseLimit = expenseLimit;
//         this.user = user;
//     }

//     public void validate() {

//         if (month == null || month < 1 || month > 12) {
//             throw new BadRequestException("Month must be between 1 and 12");
//         }

//         if (year == null || year < 2000) {
//             throw new BadRequestException("Year must be a valid year");
//         }

//         if (expenseLimit == null || expenseLimit <= 0) {
//             throw new BadRequestException("Expense limit must be greater than 0");
//         }

//         if (user == null) {
//             throw new BadRequestException("User is required");
//         }
//     }

//     public Long getId() {
//         return id;
//     }

//     public Integer getMonth() {
//         return month;
//     }

//     public Integer getYear() {
//         return year;
//     }

//     public Double getExpenseLimit() {
//         return expenseLimit;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setMonth(Integer month) {
//         this.month = month;
//     }

//     public void setYear(Integer year) {
//         this.year = year;
//     }

//     public void setExpenseLimit(Double expenseLimit) {
//         this.expenseLimit = expenseLimit;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }
// }
 
package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;

@Entity
@Table(name = "budget_plans",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "month", "year"}))
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    @OneToOne(mappedBy = "budgetPlan")
    private BudgetSummary summary;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, Integer month, Integer year,
                      Double incomeTarget, Double expenseLimit) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
    }

    public void validate() {
        if (month == null || month < 1 || month > 12) {
            throw new BadRequestException("Invalid month");
        }
        if (incomeTarget != null && incomeTarget < 0) {
            throw new BadRequestException("Income target must be >= 0");
        }
        if (expenseLimit != null && expenseLimit < 0) {
            throw new BadRequestException("Expense limit must be >= 0");
        }
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Integer getMonth() { return month; }

    public void setMonth(Integer month) { this.month = month; }

    public Integer getYear() { return year; }

    public void setYear(Integer year) { this.year = year; }

    public Double getIncomeTarget() { return incomeTarget; }

    public void setIncomeTarget(Double incomeTarget) { this.incomeTarget = incomeTarget; }

    public Double getExpenseLimit() { return expenseLimit; }

    public void setExpenseLimit(Double expenseLimit) { this.expenseLimit = expenseLimit; }
}

