package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author daniel
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }
    
    @GetMapping(path = {"/{id}"})
    public User getUserId(@PathVariable("id") int id){
        return service.getUser(id);
    }
    
    @PostMapping
    public User addUser(@RequestBody User u){        
        return service.add(u);
    }
    
    @PutMapping(path = {"/{id}"})
    public User editUser(@RequestBody User user,@PathVariable("id") long id){
        user.setId(id);
        return service.edit(user);
    }
    @DeleteMapping(path = {"/{id}"})
    public User deleteUser(@PathVariable("id")long id){
        return service.delete(id);
    }
}
