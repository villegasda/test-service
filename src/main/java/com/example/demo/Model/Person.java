/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author daniel
 */
@Entity
public class Person extends ModelBase{
    
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "celular")
    private long celular;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "birthday")
    private Date birthday;
    @Lob
    @Column(name = "image")
    private Byte[] image;
    @Transient
    private String foto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + (int) (this.celular ^ (this.celular >>> 32));
        hash = 79 * hash + Objects.hashCode(this.direccion);
        hash = 79 * hash + Objects.hashCode(this.birthday);
        hash = 79 * hash + Arrays.deepHashCode(this.image);
        hash = 79 * hash + Objects.hashCode(this.foto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.celular != other.celular) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        if (!Arrays.deepEquals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", lastName=" + lastName + ", celular=" + celular + ", direccion=" + direccion + ", birthday=" + birthday + ", image=" + image + ", foto=" + foto + '}';
    }
}
