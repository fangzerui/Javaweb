package com.example.webapp.controller;

import com.example.webapp.entity.Bill;
import com.example.webapp.entity.Product;
import com.example.webapp.entity.Shopping;
import com.example.webapp.entity.User;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    User tmp_user;
    @RequestMapping("/")
    public String show(){return "login";}
    @RequestMapping(value = "/loginIn")
    public String login(String name,String password){
        User userbean = userService.longIn(name,password);

        if(userbean!=null){
            tmp_user=userbean;
            if(userbean.getName().equals("admin")){
                return "index1";
            }
            else {
                return "index2";
            }
        }else {
            return "login";
        }
    }
    //@RequestMapping("/index1")
    @RequestMapping(value = "/to_product")
    public String queue(Model model){
        List<Product> products=userService.findAll();
        model.addAttribute("products",products);
        return "index1";
    }
/*    @RequestMapping(value = "/to_product")
    public String to_queue(){
        return "redirect:/index1";
    }*/
    @RequestMapping(value = "/to_add")
    public String to_add(){
        return "add product";
    }
    @RequestMapping(value = "/addProduct")
    public String addProduct(String name,Double price,Integer allowance,String comment){
        Integer k=userService.findProductmaxId();
        Product product=new Product();
        product.setId(k);
        product.setName(name);
        product.setPrice(price);
        product.setAllowance(allowance);
        product.setComment(comment);
        userService.save2(product);
        return "add product";
    }
    @RequestMapping(value = "toDeleteproduct")
    public String toDeleteproduct(Integer id){
        userService.Deleteproduct(id);
        return "index1";
    }
    @RequestMapping(value = "/toEditproduct")
    public String toEditproduct(Model model,Integer id){
        Product product=userService.findProductById(id);
        model.addAttribute("product",product);
        return "edit product";
    }
    @RequestMapping(value = "editProduct")
    public String editProduct(Integer id,String name,Double price,Integer allowance,String comment){
        Product product=new Product();
        product.setId(id);product.setName(name);
        product.setPrice(price);product.setAllowance(allowance);
        product.setComment(comment);
        userService.save2(product);
        return "index1";
    }
    @RequestMapping(value = "/to_register")
    public String to_register(){
        return "register";
    }
    @RequestMapping(value = "/try_register")
    public String register(String name,String email,String password){
        boolean ck=userService.check(name,email);
        if(ck==false){
            return "register";
        }
        User user=new User();
        user.setId(userService.findUsermaxId());user.setEmail(email);
        user.setName(name);user.setPassword(password);
        userService.save(user);
        return "login";
    }
    //@RequestMapping("/index2")
    @RequestMapping(value = "/to_user_product")
    public String user_product(Model model){
        List<Product> products=userService.findAll();
        model.addAttribute("products",products);
        return "index2";
    }
    @RequestMapping(value = "/logout")
    public String logout(){
        userService.DeleteUser(tmp_user.getId());
        return "login";
    }
   /* @RequestMapping(value = "/to_user_product")
    public String to_user_product(){
        return "redirect:/index2";
    }*/
    @RequestMapping(value = "/toVisitproduct")
    public String toVisitproduct(Model model,Integer id){

        Product product=userService.findProductById(id);
        if(product==null){
            return "index2";
        }
        model.addAttribute("product",product);
        return "comment";
    }
    @RequestMapping(value = "/toBuyproduct")
    public String toBuyproduct(Model model,Integer id){
        Product product=userService.findProductById(id);
        if(product==null){
            return "index2";
        }
        model.addAttribute("product",product);
        return "buy product";
    }
    @RequestMapping(value = "BuyProduct")
    public String BuyProduct(Integer id,String name,Double price,Integer allowance,Integer buy_number,String comment){
        Product product=userService.findProductById(id);
        if(product.getAllowance()<buy_number){
            return "index2";
        }
        Bill bill=new Bill();
        bill.setId(userService.findBillmaxId());
        bill.setName(name);
        bill.setUser_id(tmp_user.getId());
        bill.setUser_name(tmp_user.getName());
        bill.setProduct_id(id);bill.setPrice(price);
        bill.setNumber(buy_number);
        Double y=Double.valueOf(buy_number);
        y=y*price;
        bill.setMoney(y);
        bill.setCost(String.format("%.2f", y));
        userService.save3(bill);
        Integer g=product.getAllowance()-buy_number;
        product.setAllowance(g);
        userService.save2(product);
        return "index2";
    }
    @RequestMapping(value = "/to_edit_user")
    public String to_edit_user(Model model){
        User user=userService.findUserById(tmp_user.getId());
        model.addAttribute("user",user);
        return "change";
    }
    @RequestMapping(value = "/editUser")
    public String editUser(Integer id,String name,String password,String email){
        User user=new User();
        user.setPassword(password);user.setName(name);user.setId(id);user.setEmail(email);
        userService.save(user);
        return "index2";
    }
    @RequestMapping(value = "/toaddshop")
    public String toaddshop(Integer id){
        Shopping shopping_car=new Shopping();
        Product product=userService.findProductById(id);
        shopping_car.setId(userService.findShoppingmaxId());
        shopping_car.setUser_id(tmp_user.getId());
        shopping_car.setAllowance(product.getAllowance());
        shopping_car.setProduct_id(product.getId());
        shopping_car.setPrice(product.getPrice());
        shopping_car.setName(product.getName());
        shopping_car.setComment(product.getComment());
        userService.save4(shopping_car);
        return "index2";
    }
    @RequestMapping(value = "/to_shop")
    public String to_shop(Model model){
        List<Shopping> shops=userService.Show(tmp_user.getId());
        model.addAttribute("shops",shops);
        return "shop";
    }

    @RequestMapping(value = "/todeleteshop")
    public String todeleteshop(Integer id){
        userService.DeleteShop(id);
        return "shop";
    }
    @RequestMapping(value = "/to_bill")
    public String to_bill(Model model){
        List<Bill> bills=userService.ShowBill(tmp_user.getId());
        model.addAttribute("bills",bills);
        return "bill";
    }
    @RequestMapping(value = "/to_admin_bill")
    public String to_admin_bill(Model model){
        List<Bill>bills=userService.findBillAll();
        model.addAttribute("bills",bills);
        return "admin bill";
    }
}
