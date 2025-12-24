package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category addCategory(Category category) {
        if (repo.existsByName(category.getName())) {
            throw new BadRequestException("Duplicate category");
        }
        category.validateType();
        return repo.save(category);
    }

    public List<Category> getAllCategories() {
        return repo.findAll();
    }
}
