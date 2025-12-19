// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Category;
// import com.example.demo.repository.CategoryRepository;
// import com.example.demo.service.CategoryService;

// @Service
// public class CategoryServiceImpl implements CategoryService {

//     @Autowired
//     private CategoryRepository categoryRepository;

//     @Override
//     public Category addCategory(Category category) {
//         if (categoryRepository.existsByName(category.getName())) {
//             throw new RuntimeException("Category already exists");
//         }
//         return categoryRepository.save(category);
//     }

//     @Override
//     public List<Category> getAllCategories() {
//         return categoryRepository.findAll();
//     }
// }


package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new RuntimeException("Category already exists: " + category.getName());
        }

        final String type = category.getType();
        
        if (Category.TYPE_EXPENSE.equalsIgnoreCase(type)) {
            category.setType(Category.TYPE_EXPENSE);
        } else if (Category.TYPE_INCOME.equalsIgnoreCase(type)) {
            category.setType(Category.TYPE_INCOME);
        } else {
            category.setType(Category.TYPE_INCOME);
        }

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}



