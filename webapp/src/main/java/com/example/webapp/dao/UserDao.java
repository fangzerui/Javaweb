package com.example.webapp.dao;

import com.example.webapp.entity.Shopping;
import com.example.webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findUserByNameAndPassword(String name,String password);
    @Query(value = "select max(user.id) from user ", nativeQuery = true)
    Integer findmaxid();
    User findUserByName(String name);
    User findUserByEmail(String email);
    User findUserById(Integer id);
}
