// // // package com.example.demo.model;

// // // import jakarta.persistence.Column;
// // // import jakarta.persistence.Entity;
// // // import jakarta.persistence.GeneratedValue;
// // // import jakarta.persistence.GenerationType;
// // // import jakarta.persistence.Id;
// // // import jakarta.persistence.Table;
// // // import jakarta.persistence.UniqueConstraint;

// // //  @Entity
// // //     @Table(name = "categories", uniqueConstraints = {
// // //     @UniqueConstraint(columnNames = "name")
// // // })
// // // public class Category {
// // //     @Id
// // //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// // //     private Long id;

// // //     @Column(nullable = false, unique = true)
// // //     private String name;

// // //     @Column(nullable = false)
// // //     private String type; 

// // //     public Category(){

// // //     }

// // //     public Category(String name, String type) {
// // //         this.name = name;
// // //         this.type = type;
// // //     }

// // //     public Long getId() {
// // //         return id;
// // //     }

// // //     public String getName() {
// // //         return name;
// // //     }

// // //     public String getType() {
// // //         return type;
// // //     }

// // //     public void setId(Long id) {
// // //         this.id = id;
// // //     }

// // //     public void setName(String name) {
// // //         this.name = name;
// // //     }

// // //     public void setType(String type) {
// // //         this.type = type;
// // //     }
    



// // // }

// // package com.example.demo.model;

// // import jakarta.persistence.Column;
// // import jakarta.persistence.Entity;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.Table;

// // @Entity
// // @Table(name = "categories")

// // public class Category {

// //     public static final String TYPE_INCOME = "INCOME";
// //     public static final String TYPE_EXPENSE = "EXPENSE"; 
// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @Column(nullable = false, unique = true)
// //     private String name;


// //     @Column(nullable = false)
// //     private String type; 

// //     public Category(){

// //     }
// //     public Category(String name, String type) {
// //         this.name = name;
// //         this.type = (TYPE_EXPENSE.equalsIgnoreCase(type)) ? TYPE_EXPENSE : TYPE_INCOME;
// //     }

// //     public Long getId() {
// //         return id;
// //     }

// //     public String getName() {
// //         return name;
// //     }

// //     public String getType() {
// //         return type;
// //     }

// //     public void setId(Long id) {
// //         this.id = id;
// //     }

// //     public void setName(String name) {
// //         this.name = name;
// //     }

// //     public void setType(String type) {
// //         this.type = type;
// //     }

// // }





// package com.example.demo.model;

// import java.util.List;

// import com.example.demo.exception.BadRequestException;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "categories")
// public class Category {

//     public static final String TYPE_INCOME = "INCOME";
//     public static final String TYPE_EXPENSE = "EXPENSE";

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String name;

//     @Column(nullable = false)
//     private String type;

//     @OneToMany(mappedBy = "category")
//     private List<TransactionLog> transactionLogs;

//     public Category() {}

//     public Category(Long id, String name, String type) {
//         this.id = id;
//         this.name = name;
//         this.type = type;
//     }

//     public void validateType() {
//         if (!TYPE_INCOME.equalsIgnoreCase(type)
//                 && !TYPE_EXPENSE.equalsIgnoreCase(type)) {
//             throw new BadRequestException(
//                     "Invalid category type. Allowed values: INCOME or EXPENSE"
//             );
//         }
//         this.type = type.toUpperCase();
//     }

//     public static String getTypeIncome() {
//         return TYPE_INCOME;
//     }

//     public static String getTypeExpense() {
//         return TYPE_EXPENSE;
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

//     public List<TransactionLog> getTransactionLogs() {
//         return transactionLogs;
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

//     public void setTransactionLogs(List<TransactionLog> transactionLogs) {
//         this.transactionLogs = transactionLogs;
//     }



// }

package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "categories",
    uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore   
    private List<TransactionLog> transactionLogs;

    public Category() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
}
