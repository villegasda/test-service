package com.example.demo.Controller;

import com.example.demo.Model.Person;
import com.example.demo.Service.PersonService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author daniel
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService service;
    
    @GetMapping
    public List<Person> getPersons(){
        return service.getPersons();
    }
    
    @GetMapping(path = {"/{id}"})
    public Person getPersonById(@PathVariable("id")long ig){
        return service.getPerson(ig);
    }
    
    @PostMapping
    public Person addPerson(@RequestBody Person p){
        return service.add(p);
    }
    
    @PutMapping(path = {"/{id}"})
    public Person editPerson(@RequestBody Person p, @PathVariable("id") long id){
        p.setId(id);
        return service.edit(p);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public Person deletePerson(@PathVariable("id")long id){
        return service.delete(id);
    }
    
    @PostMapping(path = {"/{id}/image"})
    public void saveImage(@PathVariable("id")long id, @RequestParam("file") MultipartFile[] multipartFiles) throws IOException{
        for(MultipartFile uploadFile:multipartFiles){
            uploadFile.getOriginalFilename();
            service.saveImage(id, uploadFile.getInputStream());
        }
    }
    
}
