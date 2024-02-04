package net.karanbhogle.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.karanbhogle.user.dto.UserDTO;
import net.karanbhogle.user.service.UserService;

@RestController
@RequestMapping("/users/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello from USERS CONTROLLER";
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO response = userService.createUser(userDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
    	List<UserDTO> response = userService.getAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
        UserDTO response = userService.login(userDTO);

        if (response == null) {
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

