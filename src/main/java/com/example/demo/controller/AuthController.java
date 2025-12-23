
// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;

//     public AuthController(UserService userService) {
//         this.userService = userService;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userService.register(user);
//     }

//     @PostMapping("/login")
//     public String login(@RequestBody User user) {

//         User dbUser = userService.findByEmail(user.getEmail());

//         if (!dbUser.getPassword().equals(user.getPassword())) {
//             throw new BadRequestException("Invalid email or password");
//         }

//         return "Login successful for user: " + dbUser.getName();
//     }
// }

package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(
            UserService userService,
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider) {

        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public AuthResponse register(
            @RequestBody RegisterRequest request) {

        User user = new User(
                null,
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                "USER"
        );

        User saved = userService.register(user);

        return new AuthResponse(
                null,
                saved.getId(),
                saved.getEmail(),
                saved.getRole()
        );
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        User user = userService.findByEmail(request.getEmail());

        String token = jwtTokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}

