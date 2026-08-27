package com.kwayisi.aniverse.auth;

import com.kwayisi.aniverse.user.User;
import com.kwayisi.aniverse.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request){
        if (userRepository.existsByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }

        String hashedPassword =
            passwordEncoder.encode(request.getPassword());

        User user = new User(
            request.getUsername(),
            request.getEmail(), 
            hashedPassword
        );


        return userRepository.save(user);
    }

        
    
}
