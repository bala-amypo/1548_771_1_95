// // package com.example.demo.model;

// // import com.example.demo.exception.BadRequestException;

// // public class BudgetPlan {

// //     private Long id;
// //     private User user;
// //     private Integer month;
// //     private Integer year;
// //     private Double incomeTarget;
// //     private Double expenseLimit;

// //     public BudgetPlan() {}

// //     public BudgetPlan(Long id, User user, Integer month, Integer year,
// //                       Double incomeTarget, Double expenseLimit) {
// //         this.id = id;
// //         this.user = user;
// //         this.month = month;
// //         this.year = year;
// //         this.incomeTarget = incomeTarget;
// //         this.expenseLimit = expenseLimit;
// //     }

// //     public void validate() {
// //         if (month < 1 || month > 12) {
// //             throw new BadRequestException("Invalid month");
// //         }
// //     }

// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public User getUser() { return user; }
// //     public void setUser(User user) { this.user = user; }

// //     public Integer getMonth() { return month; }
// // }
// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class BudgetPlan {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Integer month;

//     private Integer year;

//     private Double totalBudget;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private User user;

//     // 🔹 REQUIRED GETTERS
//     public Integer getMonth() {
//         return month;
//     }

//     public Integer getYear() {
//         return year;
//     }

//     public User getUser() {
//         return user;
//     }

//     // 🔹 REQUIRED SETTERS
//     public void setUser(User user) {
//         this.user = user;
//     }

//     public void validate() {
//         if (month == null || month < 1 || month > 12) {
//             throw new IllegalArgumentException("Invalid month");
//         }
//         if (year == null) {
//             throw new IllegalArgumentException("Year is required");
//         }
//         if (totalBudget == null || totalBudget <= 0) {
//             throw new IllegalArgumentException("Invalid budget");
//         }
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer month;

    private Integer year;

    private Double totalBudget;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 🔹 REQUIRED GETTERS
    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public User getUser() {
        return user;
    }

    // 🔹 REQUIRED SETTERS
    public void setUser(User user) {
        this.user = user;
    }

    public void validate() {
        if (month == null || month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        if (year == null) {
            throw new IllegalArgumentException("Year is required");
        }
        if (totalBudget == null || totalBudget <= 0) {
            throw new IllegalArgumentException("Invalid budget");
        }
    }
}
