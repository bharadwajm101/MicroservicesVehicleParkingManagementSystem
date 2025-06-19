package com.parking.user_service.controller;
import com.parking.user_service.entity.User;
import com.parking.user_service.repository.UserRepository;
import com.parking.user_service.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    // @PostMapping("/register")
    // public User registerUser(@RequestBody User user) {
    //     user.setPassword(passwordEncoder.encode(user.getPassword())); // Assuming password is already hashed
    //     return userRepository.save(user);
    // }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) user.setRole("CUSTOMER"); // default role
        return ResponseEntity.ok(userRepository.save(user));
    }
 


    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody LoginRequest request){
    //     User user = userRepository.findByEmail(request.getEmail());
    //     if(user==null){
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND)
    //                 .body("User not found with email: " + request.getEmail());
    //     }
    //     if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
    //                 .body("Invalid credentails");
    //     }
    //     user.setPassword(null); // Clear password before returning user details
    //     return ResponseEntity.ok(user);
    // }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with email: " + request.getEmail());
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
 
        user.setPassword(null); // hide password in response
        return ResponseEntity.ok(user);
    }

    @GetMapping 
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
  
 
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/admin-only")
public ResponseEntity<String> getAdminOnly() {
    return ResponseEntity.ok("Hello Admin 👑, this is a protected endpoint.");
}
 
}
