// package com.example.demo3.model;

// import java.time.LocalDate;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;


// @Entity
// @Table(name = "transaction_logs")

// public class TransactionLog {
   
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     @ManyToOne
//     @JoinColumn(name = "category_id", nullable = false)
//     private Category category;

//     @Column(nullable = false)
//     private Double amount;

//     private String description;

//     @Column(nullable = false)
//     private LocalDate transactionDate;

//     public TransactionLog(){

//     }

//     public TransactionLog(User user, Category category, Double amount, String description, LocalDate transactionDate) {
//         this.user = user;
//         this.category = category;
//         this.amount = amount;
//         this.description = description;
//         this.transactionDate = transactionDate;
//     }

//     public Long getId() {
//         return id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public Category getCategory() {
//         return category;
//     }

//     public Double getAmount() {
//         return amount;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public LocalDate getTransactionDate() {
//         return transactionDate;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public void setCategory(Category category) {
//         this.category = category;
//     }

//     public void setAmount(Double amount) {
//         this.amount = amount;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public void setTransactionDate(LocalDate transactionDate) {
//         this.transactionDate = transactionDate;
//     }



// }




package com.example.demo4.model;

import java.time.LocalDate;

import com.example.demo4.exception.BadRequestException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_logs")
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private Double amount;

    private String description;

    @Column(nullable = false)
    private LocalDate transactionDate;

    public TransactionLog() {
    }

    public TransactionLog(
            Long id,
            User user,
            Category category,
            Double amount,
            String description,
            LocalDate transactionDate
    ) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public void validate() {
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Transaction amount must be greater than 0");
        }

        if (transactionDate == null) {
            throw new BadRequestException("Transaction date is required");
        }

        if (transactionDate.isAfter(LocalDate.now())) {
            throw new BadRequestException("Transaction date cannot be in the future");
        }
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Category getCategory() {
        return category;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
