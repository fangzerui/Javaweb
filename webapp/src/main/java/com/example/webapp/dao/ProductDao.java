package com.example.webapp.dao;

import com.example.webapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    @Query(value = "select max(product.id) from product ", nativeQuery = true)
    Integer findmaxid();
    Product findProductById(Integer id);
}
