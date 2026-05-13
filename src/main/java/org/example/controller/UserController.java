package org.example.controller;

import org.example.dto.RequestUser;
import org.example.dto.ResponseUser;
import org.example.entity.User;
import org.example.exception.UserNotFoundException;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
    public ResponseEntity<RequestUser> saveUser(ResponseUser user) {
       var user1 = userService.saveUser(user);
       return ResponseEntity.ok(user1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
       try{
           var user1 =userService.getUser(id);
           return ResponseEntity.ok(user1);
       } catch (UserNotFoundException e) {
          return ResponseEntity
                   .status(404)
                   .body(e.getMessage());
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        try{
            var user1 =userService.deleteUser(id);
            return ResponseEntity.ok(user1);
        } catch (UserNotFoundException e) {
            return ResponseEntity
                    .status(404)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody ResponseUser user) {
        try{
            var user1 =userService.updateUser(id,user);
            return ResponseEntity.ok(user1);
        } catch (UserNotFoundException e) {
            return ResponseEntity
                    .status(404)
                    .body(e.getMessage());
        }
    }
}
