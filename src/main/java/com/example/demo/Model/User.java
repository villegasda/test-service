package com.example.demo.Model;

import javax.persistence.*;

/**
 *
 * @author daniel
 */
@Entity
public class User extends ModelBase{
    
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    
    @JoinColumn(name = "id_person", unique = true)
    @OneToOne
    private Person person;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", person=" + person + '}';
    }

    
    
       
}
