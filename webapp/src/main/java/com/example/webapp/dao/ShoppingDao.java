package com.example.webapp.dao;

import com.example.webapp.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingDao extends JpaRepository<Shopping,Integer> {

    @Query(value = "select max(shopping.id) from shopping ", nativeQuery = true)
    Integer findmaxid();
   // @Query(value = "select * from shopping  where shopping.user_id=?1", nativeQuery = true)
   @Query(value = "select b from Shopping b where b.user_id = :user_id")
   List<Shopping> findByUserdParam(@Param("user_id") Integer user_id);
}
