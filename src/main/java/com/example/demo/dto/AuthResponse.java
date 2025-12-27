// package com.example.demo.dto;

// public class AuthResponse {

//     private String token;

//     public AuthResponse() {
//     }

//     public AuthResponse(String token) {
//         this.token = token;
//     }

//     public String getToken() {
//         return token;
//     }

//     public void setToken(String token) {
//         this.token = token;
//     }
// }

package com.example.demo.dto;

public class AuthResponse {

    private String message;
    private String token;

    public AuthResponse() {
    }

    public AuthResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
