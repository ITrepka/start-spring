package com.craftincode.startspring.controllers;

import com.craftincode.startspring.model.User;
import com.craftincode.startspring.model.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
@Controller
public class UserController {
    UserService userService = new UserService();

    @RequestMapping (method = RequestMethod.GET, value = "/api/v1/users")
    @ResponseBody
    public String getAllUsers(@RequestParam(required = false) Integer birthYear) {
        if (birthYear != null) {
            return userService.findUsersByBirthYear(birthYear).toString();
        }
        return userService.getAllUsers().toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/users/{id}")
    @ResponseBody
    public String getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return user == null ? null : user.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/users")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User has been added";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/users/{id}")
    @ResponseBody
    public String updateUserById(@PathVariable int id, @RequestBody User user) {
        userService.updateUserById(id, user);
        return "User has been updated";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/users/{id}")
    @ResponseBody
    public String deleteUserById (@PathVariable int id){
        userService.deleteUserById(id);
        return "User has been deleted";
    }

}
