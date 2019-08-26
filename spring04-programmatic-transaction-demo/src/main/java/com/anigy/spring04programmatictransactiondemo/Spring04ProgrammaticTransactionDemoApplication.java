package com.anigy.spring04programmatictransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class Spring04ProgrammaticTransactionDemoApplication implements CommandLineRunner {
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Spring04ProgrammaticTransactionDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("COUNT BEFORE TRANSACTION: {}", getCount());
        // replaced with lambda
        transactionTemplate.execute((TransactionCallback)transactionStatus -> {
            jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'AAA')");
            log.info("COUNT IN TRANSACTION: {}", getCount());
            transactionStatus.setRollbackOnly();
            return null;
        });
        // transactionTemplate.execute(new TransactionCallback() {
        //
        // @Override
        // public Object doInTransaction(TransactionStatus transactionStatus) {
        // jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'AAA')");
        // log.info("COUNT IN TRANSACTION: {}", getCount());
        // transactionStatus.setRollbackOnly();
        // return null;
        // }
        // });
        log.info("COUNT AFTER TRANSACTION: {}", getCount());
    }

    private long getCount() {
        List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM FOO");
        return (long)result.get(0).get("CNT");
    }
}
