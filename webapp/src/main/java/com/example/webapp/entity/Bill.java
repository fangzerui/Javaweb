package com.example.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    private Integer id;
    private Integer product_id;
    private Integer user_id;
    private Double price;
    private Integer number;
    private Double money;
    private String name;
    private String user_name;
    private String cost;
    public void setId(Integer id){this.id=id;}
    public void setProduct_id(Integer product_id){this.product_id=product_id;}
    public void setUser_id(Integer user_id){this.user_id=user_id;}
    public void setPrice(Double price){this.price=price;}
    public void setNumber(Integer number){this.number=number;}
    public void setMoney(Double money){this.money=money;}
    public void setName(String name){this.name=name;}
    public void setUser_name(String user_name){this.user_name=user_name;}
    public void setCost(String cost){this.cost=cost;}
    public Integer getId(){return id;}
    public Integer getProduct_id(){return product_id;}
    public Integer getUser_id(){return user_id;}
    public Double getPrice(){return price;}
    public Integer getNumber(){return number;}
    public Double getMoney(){return money;}
    public String getName(){return name;}
    public String getUser_name(){return user_name;}
    public String getCost(){return cost;}
}
