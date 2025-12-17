// package com.example.demo1.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Category {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)

//     private Long id;
//     @Column(unique=true)
//     private String name;
//     private String type;

//     public Category(){

//     }

//     public Category(String name, String type) {
//         this.name = name;
//         this.type = type;
//     }

//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getType() {
//         return type;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setType(String type) {
//         this.type = type;
//     }
    
    
// }
