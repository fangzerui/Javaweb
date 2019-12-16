package com.example.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shopping")
public class Shopping {
    @Id
    private Integer id;
    private Integer user_id;
    private String name;
    private Double price;
    private Integer allowance;
    private String comment;
    private Integer product_id;
    public void setId(Integer id){this.id=id;}
    public void setUser_id(Integer user_id){this.user_id=user_id;}
    public void setName(String name){this.name=name;}
    public void setPrice(Double price){this.price=price;}
    public void setAllowance(Integer allowance){this.allowance=allowance;}
    public void setComment(String comment){this.comment=comment;}
    public void setProduct_id(Integer product_id){this.product_id=product_id;}
    public Integer getId(){return id;}
    public Integer getUser_id(){return user_id;}
    public String getName(){return name;}
    public Double getPrice(){return price;}
    public Integer getAllowance(){return allowance;}
    public String getComment(){return comment;}
    public Integer getProduct_id(){return product_id;}
}
