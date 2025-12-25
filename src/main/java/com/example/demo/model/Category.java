package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categories")
public class Category {
    
    public static final String TYPE_INCOME = "INCOME";
    public static final String TYPE_EXPENSE = "EXPENSE";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = false)
    private String type;
    
    // No-arg constructor
    public Category() {
    }
    
    // Parameterized constructor: id, name, type
    public Category(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    // Validation method
    public void validateType() {
        if (!TYPE_INCOME.equals(type) && !TYPE_EXPENSE.equals(type)) {
            throw new BadRequestException("Category type must be either INCOME or EXPENSE");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
