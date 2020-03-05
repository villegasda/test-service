package com.example.demo.Repository;

import com.example.demo.Model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daniel
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    User findById(long id);
    User save(User u);
    User deleteById(long id);
}
