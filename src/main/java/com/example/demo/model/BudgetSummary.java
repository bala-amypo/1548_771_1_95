
// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "budget_summaries")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class BudgetSummary {

//     public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
//     public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "budget_plan_id", nullable = false, unique = true)
//     private BudgetPlan budgetPlan;

//     @Column(nullable = false)
//     private Double totalIncome;

//     @Column(nullable = false)
//     private Double totalExpense;

//     @Column(nullable = false)
//     private String status;

//     @Column(nullable = false)
//     private LocalDateTime generatedAt;

//     @PrePersist
//     protected void onCreate() {
//         this.generatedAt = LocalDateTime.now();
//     }
// }
