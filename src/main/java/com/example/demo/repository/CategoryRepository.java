package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.model.Category;

    public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}


