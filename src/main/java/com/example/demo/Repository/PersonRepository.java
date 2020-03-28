package com.example.demo.Repository;

import com.example.demo.Model.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author daniel
 */
public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findAll();
    Person findById(long id);
    Person save(Person p);
    Person deleteById(long id);    
}
