package com.example.webapp.service;

import com.example.webapp.dao.BillDao;
import com.example.webapp.dao.ProductDao;
import com.example.webapp.dao.ShoppingDao;
import com.example.webapp.dao.UserDao;
import com.example.webapp.entity.Bill;
import com.example.webapp.entity.Product;
import com.example.webapp.entity.Shopping;
import com.example.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BillDao billDao;
    @Autowired
    private ShoppingDao shoppingDao;
    @Override
    public  User longIn(String name,String password){

        return userDao.findUserByNameAndPassword(name,password);
    }
    @Override
    public User save(User user){
        return userDao.save(user);
    }
    @Override
    public List<Product> findAll(){
        return productDao.findAll();
    }
    @Override
    public Integer  findProductmaxId(){
        return productDao.findmaxid()+1;
    }
    @Override
    public Product save2(Product product){
        return productDao.save(product);
    }
    @Override
    public void Deleteproduct(Integer id){
        productDao.deleteById(id);
        return;
    }
    @Override
    public Product findProductById(Integer id){
        return productDao.findProductById(id);
    }
    @Override
    public Integer findUsermaxId(){
        return userDao.findmaxid()+1;
    }
    @Override
    public Integer findBillmaxId(){
        if(billDao.findmaxid()==null){
            return 1;
        }
        return billDao.findmaxid()+1;
    }
    @Override
    public  User findUserById(Integer id){
        return userDao.findUserById(id);
    }
    @Override
    public Integer findShoppingmaxId(){
        if(shoppingDao.findmaxid()==null)return 1;
        return shoppingDao.findmaxid()+1;
    }
    @Override
    public boolean check(String name,String email){
        User user=userDao.findUserByName(name);
        if(user!=null)return false;
        User user1=userDao.findUserByEmail(email);
        if(user1!=null)return false;
        return true;
    }
    @Override
    public Bill save3(Bill bill){
        return  billDao.save(bill);
    }
    @Override
    public Shopping save4(Shopping shopping_car){
        return shoppingDao.save(shopping_car);
    }
    @Override
    public List<Shopping> Show(Integer user_id){
        List<Shopping> shoppings=shoppingDao.findByUserdParam(user_id);
        List<Shopping> an=new ArrayList<Shopping>();
        for(int i=0;i<shoppings.size();++i){
            if(productDao.findProductById(shoppings.get(i).getProduct_id())==null){
                shoppingDao.deleteById(shoppings.get(i).getId());
                continue;
            }
            else{
                boolean flag=false;
                for(int j=0;j<an.size();++j){
                    if(an.get(j).getProduct_id()==shoppings.get(i).getProduct_id()){
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    Shopping s=shoppings.get(i);
                    Product product=productDao.findProductById(s.getProduct_id());
                    s.setName(product.getName());s.setAllowance(product.getAllowance());
                    s.setPrice(product.getPrice());s.setComment(product.getComment());
                    shoppingDao.save(s);
                    an.add(s);
                }
                else{
                    shoppingDao.deleteById(shoppings.get(i).getId());
                }
            }
        }
        return an;
    }
    @Override
    public List<Bill> ShowBill(Integer user_id){
        return billDao.findByUserdParam(user_id);
    }
    @Override
    public List<Bill> findBillAll(){
        return billDao.findAll();
    }
    @Override
    public void DeleteShop(Integer id){
        shoppingDao.deleteById(id);
        return;
    }
    @Override
    public void DeleteUser(Integer id){
        userDao.deleteById(id);
        return;
    }
}
