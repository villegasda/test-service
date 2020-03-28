package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Utils.ImageUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class PersonServiceImp implements PersonService{
    @Autowired
    PersonRepository repository;

    @Override
    public List<Person> getPersons() {
        List<Person> persons = repository.findAll();
        for (Person person : persons) {
            getImage(person, person.getImage());
        }
        return persons;
    }

    @Override
    public Person getPerson(long id) {
        return repository.findById(id);
    }

    @Override
    public Person add(Person p) {
        return repository.save(p);
    }

    @Override
    public Person edit(Person p) {
        return repository.save(p);
    }

    @Override
    public Person delete(long id) {
        return repository.deleteById(id);
    }

    @Override
    public void saveImage(long id, InputStream file) {
        Person p = repository.findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            p.setImage(bytes);            
            repository.save(p);
        } catch (IOException e) {
            System.err.println("Error reading file"+e);
        }
    }

    @Override
    public void getImage(Person p, Byte[] foto) {
        byte[] image = new byte[foto.length];
        for(int i=0;i<foto.length;i++){
            image[i]=foto[i];
        }
        String fotoConvert = Base64.encodeBase64String(image);
        p.setFoto(fotoConvert);
        System.out.println("Images "+p.getFoto());
    }
}
