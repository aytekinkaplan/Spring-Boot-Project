package com.project.springbootproject.controllers;

import com.project.springbootproject.entities.User;
import com.project.springbootproject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor injection for UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to create a new user
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }

    // Endpoint to retrieve a specific user by ID
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        // Custom exception
        return userService.getOneUser(userId);
    }

    // Endpoint to update an existing user by ID
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
        return userService.updateOneUser(userId, newUser);
    }

    // Endpoint to delete an existing user by ID
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}

// Explanation:
// @RestController: This annotation indicates that the class defines a RESTful controller. It automatically
// serializes return objects into JSON and binds the HTTP request body to method parameters.
// @RequestMapping("/users"): Specifies the base URI path for all HTTP requests handled by this controller.
// private final UserService userService;: Declares a private field userService of type UserService which will be
// injected using constructor-based dependency injection.
// UserController(UserService userService): Constructor for UserController that injects the UserService bean.
// @GetMapping: Handles HTTP GET requests. In this case, it's used to retrieve all users or a specific user by ID.
// @PostMapping: Handles HTTP POST requests. It's used to create a new user.
// @PutMapping: Handles HTTP PUT requests. It's used to update an existing user.
// @DeleteMapping: Handles HTTP DELETE requests. It's used to delete an existing user.
// @RequestBody: Indicates that the method parameter should be bound to the body of the HTTP request. In this case,
// it's used to create a new user or update an existing one.
// @PathVariable: Used to bind method parameters to URI template variables. In this case, it's used to retrieve a
// specific user by its ID or to delete a user by its ID.
// List<User>: The return type of methods that retrieve multiple users.
// User: The return type of methods that retrieve a single user.
// void: The return type of methods that perform operations like creating or deleting a user, where no specific
// data needs to be returned.
