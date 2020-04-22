package com.anigy.spring05declarativetransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Slf4j
public class Spring05DeclarativeTransactionDemoApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FooService fooService;

    public static void main(String[] args) {
        SpringApplication.run(Spring05DeclarativeTransactionDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fooService.insertRecord();
        log.info("AAA {}", fooService.getCount("AAA"));

        try {
            fooService.insertThenRollback();
        } catch (RollbackException e) {
            log.info("BBB {}", fooService.getCount("BBB"));
        }

        try {
            fooService.invokeInsertThenRollback();
        } catch (RollbackException e) {
            log.info("BBB {}", fooService.getCount("BBB"));
        }
    }

}
