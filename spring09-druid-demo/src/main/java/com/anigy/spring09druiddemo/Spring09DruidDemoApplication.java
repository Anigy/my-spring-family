package com.anigy.spring09druiddemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class Spring09DruidDemoApplication implements CommandLineRunner {

    @Autowired
    private FooService fooService;
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Spring09DruidDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(dataSource.toString());
        new Thread(() -> fooService.selectForUpdate()).start();
        new Thread(() -> fooService.selectForUpdate()).start();
    }
}
