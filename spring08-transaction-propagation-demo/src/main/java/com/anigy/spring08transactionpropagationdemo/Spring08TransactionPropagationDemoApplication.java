package com.anigy.spring08transactionpropagationdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Slf4j
public class Spring08TransactionPropagationDemoApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FooService fooService;

    public static void main(String[] args) {
        SpringApplication.run(Spring08TransactionPropagationDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            fooService.invokeInsertThenRollBack();
        } catch (Exception e) {
            log.error("RollbackException", e);
        }
        jdbcTemplate.queryForList("SELECT * FROM FOO").forEach(
                row -> log.info(row.toString()));
        log.info("AAA-1 {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='AAA'", Long.class));
        log.info("BBB-1 {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='BBB'", Long.class));
    }
}
