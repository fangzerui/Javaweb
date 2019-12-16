package com.example.webapp.dao;

import com.example.webapp.entity.Bill;
import com.example.webapp.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDao extends JpaRepository<Bill,Integer> {
    @Query(value = "select max(bill.id) from bill ", nativeQuery = true)
    Integer findmaxid();
    @Query(value = "select b from Bill b where b.user_id = :user_id")
    List<Bill> findByUserdParam(@Param("user_id") Integer user_id);
    List<Bill> findAll();
}
