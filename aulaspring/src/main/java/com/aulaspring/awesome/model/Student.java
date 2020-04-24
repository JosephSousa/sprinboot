package com.aulaspring.awesome.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Joseph
 * @Email jsantos.te@gmail.com
 */
@Entity
public class Student extends AbstractEntity{
       
    @NotEmpty
    private String name;
    @Email
    @NotEmpty
    private String email;
    
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }  
    
}
