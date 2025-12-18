package com.example.demo3.service;

import java.util.List;

import com.example.demo3.model.Category;

    public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
}
