// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Category;
// import com.example.demo.service.CategoryService;

// @RestController
// @RequestMapping("/categories")
// public class CategoryController {

//     @Autowired
//     private CategoryService service;

//     @PostMapping
//     public Category add(@RequestBody Category category) {
//         return service.addCategory(category);
//     }

//     @GetMapping
//     public List<Category> all() {
//         return service.getAllCategories();
//     }
// }
