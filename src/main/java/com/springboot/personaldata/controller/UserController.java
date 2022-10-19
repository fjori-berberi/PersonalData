package com.springboot.personaldata.controller;

import com.springboot.personaldata.service.UserService;
import com.springboot.personaldata.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/personaldata") // This means URL's start with /demo (after Application path)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    //add new user to hungernetdb.user
    public ResponseEntity<String> addNewUser(@RequestParam String name, @RequestParam String surname) {
        return userService.addNewUser(name,surname);
    }


    @GetMapping(path = "/findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> user = userService.findAll();
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path="/delete")
	public ResponseEntity<String> deleteByUserId(@RequestParam int id){
		return userService.deleteUserById(id);
	  
  }
}