package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(int id) {
        return repository.findById(id);
    }

    @Override
    public User add(User u) {
        return repository.save(u);
    }

    @Override
    public User edit(User u) {
        return repository.save(u);
    }

    @Override
    public User delete(int id) {
        return repository.deleteById(id);
    }    
}
