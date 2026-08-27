package com.kwayisi.aniverse.auth;

import com.kwayisi.aniverse.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
        @RequestBody RegisterRequest request){
            User user = authService.register(request);

            AuthResponse response = new AuthResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
            );

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
        }
}
