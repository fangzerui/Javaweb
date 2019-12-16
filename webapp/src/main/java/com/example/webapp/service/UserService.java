package com.example.webapp.service;

import com.example.webapp.entity.Bill;
import com.example.webapp.entity.Product;
import com.example.webapp.entity.Shopping;
import com.example.webapp.entity.User;

import java.util.List;

public interface UserService {
    User longIn(String name,String password);
    User save(User user);
    List<Product> findAll();
    Integer findProductmaxId();
    Integer findUsermaxId();
    Integer findBillmaxId();
    Integer findShoppingmaxId();
    Product save2(Product product);
    Bill save3(Bill bill);
    Shopping save4(Shopping shopping_car);
    List<Shopping> Show(Integer user_id);
    List<Bill> ShowBill(Integer user_id);
    void Deleteproduct(Integer id);
    Product findProductById(Integer id);
    User findUserById(Integer id);
    boolean check(String name,String email);
    List<Bill> findBillAll();
    void DeleteShop(Integer id);
    void DeleteUser(Integer id);
}
