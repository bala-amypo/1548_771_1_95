package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "transaction_logs")
public class TransactionLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @Column(nullable = false)
    private Double amount;
    
    @Column(length = 500)
    private String description;
    
    @Column(nullable = false)
    private LocalDate transactionDate;
    
    // No-arg constructor
    public TransactionLog() {
    }
    
    // Parameterized constructor: id, user, category, amount, description, transactionDate
    public TransactionLog(Long id, User user, Category category, Double amount, 
                         String description, LocalDate transactionDate) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
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
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    // Validation method
    public void validate() {
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Transaction amount must be greater than 0");
        }
        if (transactionDate != null && transactionDate.isAfter(LocalDate.now())) {
            throw new BadRequestException("Transaction date cannot be in the future");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionLog that = (TransactionLog) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
