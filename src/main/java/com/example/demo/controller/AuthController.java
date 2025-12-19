
// // package com.example.demo.controller;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import com.example.demo.model.User;
// // import com.example.demo.service.UserService;

// // @RestController
// // @RequestMapping("/auth")
// // public class AuthController {

// //     @Autowired
// //     private UserService userService;

// //     @PostMapping("/register")
// //     public User register(@RequestBody User user) {
// //         return userService.register(user);
// //     }

// //     @PostMapping("/login")
// //     public String login(@RequestBody User user) {
// //         User dbUser = userService.findByEmail(user.getEmail());

// //         if (dbUser == null) {
// //             return "Invalid email or password";
// //         }

// //         if (dbUser.getPassword().equals(user.getPassword())) {
// //             return "Login successful";
// //         }

// //         return "Invalid email or password";
// //     }
// // }

// // package com.example.demo.controller;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import com.example.demo.model.User;
// // import com.example.demo.service.UserService;

// // @RestController
// // @RequestMapping("/auth")
// // public class AuthController {

// //     @Autowired
// //     private UserService userService;

// //     @PostMapping("/register")
// //     public User register(@RequestBody User user) {
// //         return userService.register(user);
// //     }
// //     @PostMapping("/login")
// //     public String login(@RequestBody User user) {
// //         User dbUser = userService.findByEmail(user.getEmail());

// //         if (dbUser == null) {
// //             return "Invalid email or password";
// //         }
// //         if (dbUser.getPassword().equals(user.getPassword())) {
// //             return "Login successful! Welcome " + dbUser.getName() + " (Role: " + dbUser.getRole() + ")";
// //         }

// //         return "Invalid email or password";
// //     }
// // }

// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userService.register(user);
//     }
//     @PostMapping("/login")
//     public String login(@RequestBody User user) {
//         User dbUser = userService.findByEmail(user.getEmail());

//         if (dbUser == null) {
//             return "Invalid email or password";
//         }
//         if (dbUser.getPassword().equals(user.getPassword())) {
//             return "Login successful! Welcome " + dbUser.getName() + " (Role: " + dbUser.getRole() + ")";
//         }

//         return "Invalid email or password";
//     }
// }


package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.exception.BadRequestException;
import com.example.demo4.model.User;
import com.example.demo4.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = userService.findByEmail(user.getEmail());

        if (!dbUser.getPassword().equals(user.getPassword())) {
            throw new BadRequestException("Invalid email or password");
        }

        return "Login successful for user: " + dbUser.getName();
    }
}


