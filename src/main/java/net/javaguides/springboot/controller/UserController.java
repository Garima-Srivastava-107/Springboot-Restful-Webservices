package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    // build create User REST API


    // build create User REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //http://localhost:8082/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User getUser=userService.getUserById(id);
        return new ResponseEntity<>(getUser,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUserById(){
        List<User> getUser=userService.getAllUserById();
        return new ResponseEntity<>(getUser,HttpStatus.OK);
    }
    //Build Update User REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        User updatedUser=userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    //Build delete User rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Successfully deleted",HttpStatus.OK);
    }

}
