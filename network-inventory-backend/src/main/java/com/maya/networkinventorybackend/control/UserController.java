package com.maya.networkinventorybackend.control;

import com.maya.networkinventorybackend.model.User;
import com.maya.networkinventorybackend.repository.UserRepository;
import com.maya.networkinventorybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserService userService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Implement user registration logic and save user to the database
        user.setApprovedBySuperAdmin(false); // Initially not approved
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/approve/{userId}")
    public ResponseEntity<?> approveUser(@PathVariable Long userId) {
        // Implement Super Admin approval logic
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setApprovedBySuperAdmin(true);
            userRepository.save(user);
            return ResponseEntity.ok("User approved by Super Admin.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);

            return ResponseEntity.ok("User deleted by Super Admin.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
        public List<User> listUsers() {
            return userRepository.findAll();
        }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Check if the username and password match any user in the repository
        User user = userRepository.findByUsername(username);

        Map<String, Object> response = new HashMap<>();

        if (user != null && user.getPassword().equals(password)) {
            if (user.isApprovedBySuperAdmin()) {
                response.put("approved", true);
                response.put("message", "Login successful");
            } else {
                response.put("approved", false);
                response.put("message", "User is not approved by admin yet");
            }
        } else {
            response.put("approved", false);
            response.put("message", "Invalid credentials");
        }

        return response;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User user) {
        System.out.println(userId);
        System.out.println(user);
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            // Update the user fields from the 'user' parameter as needed
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setRole(user.getRole());

            userRepository.save(updatedUser);
            return ResponseEntity.ok("User updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
