package com.example.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    private Integer id;
    private String name;
    private String password;
    private String email;
    public void setId(Integer id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setPassword(String password){this.password=password;}
    public void setEmail(String email){this.email=email;}
    public Integer getId(){return id;}
    public String getName(){return name;}
    public String getPassword(){return password;}
    public String getEmail(){return email;}
}
