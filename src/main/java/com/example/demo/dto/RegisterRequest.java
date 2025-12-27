// package com.example.demo.dto;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;

// public class RegisterRequest {

//     @NotBlank
//     private String name;

//     @Email
//     @NotBlank
//     private String email;

//     @NotBlank
//     private String password;

//     private String role = "USER";

//     public RegisterRequest() {}

//     public RegisterRequest(String name, String email, String password) {
//         this.name = name;
//         this.email = email;
//         this.password = password;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public String getRole() {
//         return role;
//     }
// }


package com.example.demo.dto;

public class RegisterRequest {

    private String email;
    private String password;

    public RegisterRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
