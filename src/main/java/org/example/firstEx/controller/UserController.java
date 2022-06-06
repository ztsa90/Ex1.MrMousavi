package org.example.firstEx.controller;


import org.example.firstEx.model.User;
import org.example.firstEx.service.IUserService;
import org.example.firstEx.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(value="/add")
    public User saving(@RequestBody User user)
    {
        return userService.save(user);
    }

    @GetMapping(value="/get")
    public List<User> getting()
    {return userService.getAll();}

    @GetMapping(value="/getById")
    public User getById(@PathVariable Long id)
    {
        return userService.getById(id);
    }
     @DeleteMapping("/delete")
    public void delete(@PathVariable User user){
        userService.delete(user);
     }
     @PostMapping(value = "/update")
    public User update(@RequestBody User user)
     {
         return userService.update(user);
     }

}
