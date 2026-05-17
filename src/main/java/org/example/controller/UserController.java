package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.RequestUser;
import org.example.dto.ResponseUser;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseUser> saveUser(@Valid @RequestBody RequestUser user) {
        var user1 = userService.saveUser(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable Integer id) {
        var user1 = userService.getUser(id);
        return ResponseEntity.ok(user1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUser> deleteUser(@PathVariable Integer id) {
        var user1 = userService.deleteUser(id);
        return ResponseEntity.ok(user1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUser> updateUser(@PathVariable Integer id, @Valid @RequestBody RequestUser user) {
        var user1 = userService.updateUser(id, user);
        return ResponseEntity.ok(user1);
    }
}
