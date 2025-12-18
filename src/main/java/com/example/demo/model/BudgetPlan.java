// package com.example.demo1.model;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.Max;

// public class BudgetPlan {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)

//     private Long id;
//     private User user;
//     @Min(value =1)
//     @Max(value =12)
//     private Integer month;
//     private Integer year;
//     @Min(value = 0)
//     private Double IncomeTarget;
//     @Min(value = 0)
//     private Double ExpenseLimit;
//     public BudgetPlan(){

//     }
//     public BudgetPlan(User user, Integer month, Integer year, Double incomeTarget, Double expenseLimit) {
//         this.user = user;
//         this.month = month;
//         this.year = year;
//         IncomeTarget = incomeTarget;
//         ExpenseLimit = expenseLimit;
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
//         return IncomeTarget;
//     }
//     public Double getExpenseLimit() {
//         return ExpenseLimit;
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
//         IncomeTarget = incomeTarget;
//     }
//     public void setExpenseLimit(Double expenseLimit) {
//         ExpenseLimit = expenseLimit;
//     }

    
    
// }
