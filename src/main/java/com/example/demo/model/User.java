// package com.example.demo.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.validation.constraints.Email;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//         @GeneratedValue(strategy = GenerationType.IDENTITY)
//             private Long id;

//                 @Column(nullable = false)
//                     private String name;

//                         @Email
//                             @Column(unique = true, nullable = false)
//                                 private String email;

//                                     @Column(nullable = false)
//                                         private String password;

//                                             @Column(nullable = false)
//                                                 private String role;

//                                                     public User() {
//                                                         }

//                                                             public User(String name, String email, String password, String role) {
//                                                                     this.name = name;
//                                                                             this.email = email;
//                                                                                     this.password = password;
//                                                                                             this.role = role;
//                                                                                                 }

//                                                                                                     public Long getId() {
//                                                                                                             return id;
//                                                                                                                 }

//                                                                                                                     public String getName() {
//                                                                                                                             return name;
//                                                                                                                                 }

//                                                                                                                                     public String getEmail() {
//                                                                                                                                             return email;
//                                                                                                                                                 }

//                                                                                                                                                     public String getPassword() {
//                                                                                                                                                             return password;
//                                                                                                                                                                 }

//                                                                                                                                                                     public String getRole() {
//                                                                                                                                                                             return role;
//                                                                                                                                                                                 }

//                                                                                                                                                                                     public void setId(Long id) {
//                                                                                                                                                                                             this.id = id;
//                                                                                                                                                                                                 }

//                                                                                                                                                                                                     public void setName(String name) {
//                                                                                                                                                                                                             this.name = name;
//                                                                                                                                                                                                                 }

//                                                                                                                                                                                                                     public void setEmail(String email) {
//                                                                                                                                                                                                                             this.email = email;
//                                                                                                                                                                                                                                 }

//                                                                                                                                                                                                                                     public void setPassword(String password) {
//                                                                                                                                                                                                                                             this.password = password;
//                                                                                                                                                                                                                                                 }

//                                                                                                                                                                                                                                                     public void setRole(String role) {
//                                                                                                                                                                                                                                                             this.role = role;
//                                                                                                                                                                                                                                                                 }

                                                                                                                                                                                                                                                                   
//                                                                                                                                                                                                                                                                    }

package com.example.demo3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; 

    public enum Role{
        USER,
        ADMIN
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER; 

    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = (role == null) ? Role.USER : role;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

