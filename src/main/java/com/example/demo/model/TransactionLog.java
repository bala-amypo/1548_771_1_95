// // package com.example.demo.model;

// // import com.example.demo.exception.BadRequestException;
// // import jakarta.persistence.*;
// // import java.time.LocalDate;

// // @Entity
// // @Table(name = "transaction_logs")
// // public class TransactionLog {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @ManyToOne
// //     @JoinColumn(name = "user_id")
// //     private User user;

// //     @ManyToOne
// //     @JoinColumn(name = "category_id")
// //     private Category category;

// //     private Double amount;
// //     private String description;
// //     private LocalDate transactionDate;

// //     public TransactionLog() {}

// //     public TransactionLog(Long id, User user, Category category,
// //                           Double amount, String description, LocalDate transactionDate) {
// //         this.id = id;
// //         this.user = user;
// //         this.category = category;
// //         this.amount = amount;
// //         this.description = description;
// //         this.transactionDate = transactionDate;
// //     }

// //     public void validate() {
// //         if (amount == null || amount <= 0) {
// //             throw new BadRequestException("Amount must be positive");
// //         }
// //         if (transactionDate != null && transactionDate.isAfter(LocalDate.now())) {
// //             throw new BadRequestException("Transaction date cannot be in the future");
// //         }
// //     }

// //     // getters & setters
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public User getUser() { return user; }
// //     public void setUser(User user) { this.user = user; }

// //     public Category getCategory() { return category; }
// //     public void setCategory(Category category) { this.category = category; }

// //     public Double getAmount() { return amount; }
// //     public void setAmount(Double amount) { this.amount = amount; }

// //     public String getDescription() { return description; }
// //     public void setDescription(String description) { this.description = description; }

// //     public LocalDate getTransactionDate() { return transactionDate; }
// //     public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }
// // }
// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDate;

// @Entity
// @Table(name = "transaction_logs")
// public class TransactionLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private User user;

//     @ManyToOne
//     @JoinColumn(name = "category_id")
//     private Category category;

//     private Double amount;
//     private String description;
//     private LocalDate transactionDate;

//     public TransactionLog() {}

//     // getters & setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public Category getCategory() { return category; }
//     public void setCategory(Category category) { this.category = category; }

//     public Double getAmount() { return amount; }
//     public void setAmount(Double amount) { this.amount = amount; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public LocalDate getTransactionDate() { return transactionDate; }
//     public void setTransactionDate(LocalDate transactionDate) {
//         this.transactionDate = transactionDate;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction_logs")
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate transactionDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // ===================== VALIDATION =====================
    public void validate() {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (transactionDate == null) {
            throw new IllegalArgumentException("Transaction date is required");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category is required");
        }
    }

    // ===================== GETTERS & SETTERS =====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
