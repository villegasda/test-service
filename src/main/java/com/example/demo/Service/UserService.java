package com.example.demo.Service;

import com.example.demo.Model.User;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface UserService {
    List<User> getUsers();
    User getUser(int id);
    User add(User u);
    User edit(User u);
    User delete(int id);    
}
