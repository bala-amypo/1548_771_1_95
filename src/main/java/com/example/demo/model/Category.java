// package com.example.demo.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;

//  @Entity
//     @Table(name = "categories", uniqueConstraints = {
//     @UniqueConstraint(columnNames = "name")
// })
// public class Category {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String name;

//     @Column(nullable = false)
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

package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public Category(){

    }
    public Category(String name, String type) {
        this.name = name;
        this.type = (TYPE_EXPENSE.equalsIgnoreCase(type)) ? TYPE_EXPENSE : TYPE_INCOME;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

}

