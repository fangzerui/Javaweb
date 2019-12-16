package com.example.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class WebappApplicationTests {

    @Resource
    private DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(this.dataSource);
    }

}
