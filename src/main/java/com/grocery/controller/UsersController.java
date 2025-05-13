package com.grocery.controller;

import com.grocery.model.Users;
import com.grocery.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getProfiles(){
        List<Users> users = usersService.getProfiles();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();  // 204 No Content
        }
        return ResponseEntity.ok(users);
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user){
        try {
            if (user.getFirst_name() == null || user.getLast_name() == null || user.getUsername() == null
                        || user.getEmail() == null || user.getPassword() == null) {
                return ResponseEntity.badRequest().body("Missing required fields: first_name, last_name, email, username or password.");
            }
            int rows = usersService.registerUser(user);
            if (rows > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body(user);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Could not insert user due to server error.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error: " + e.getMessage());
        }
    }


}
