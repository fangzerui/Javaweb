package com.example.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    private Integer id;
    private String name;
    private Double price;
    private Integer allowance;
    private String comment;
    public void setId(Integer id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setPrice(Double price){this.price=price;}
    public void setAllowance(Integer allowance){this.allowance=allowance;}
    public void setComment(String comment){this.comment=comment;}
    public Integer getId(){return id;}
    public String getName(){return name;}
    public Double getPrice(){return price;}
    public Integer getAllowance(){return allowance;}
    public String getComment(){return comment;}
}
