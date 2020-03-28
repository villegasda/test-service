/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Service;

import com.example.demo.Model.Person;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface PersonService {
    List<Person> getPersons();
    Person getPerson(long id);
    Person add(Person p);
    Person edit(Person p);
    Person delete(long id);
    void saveImage(long id, InputStream image);
    void getImage(Person p, Byte[] foto);
}
