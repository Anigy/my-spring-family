package com.anigy.spring06simplejdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring06SimpleJdbcDemoApplication implements CommandLineRunner {

    @Autowired
    private FooDao fooDao;
    @Autowired
    private BatchFooDao batchFooDao;

    public static void main(String[] args) {
        SpringApplication.run(Spring06SimpleJdbcDemoApplication.class, args);
    }

    @Autowired
    @Bean
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("FOO").usingGeneratedKeyColumns("ID");
    }

    @Autowired
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void run(String... args) throws Exception {
        fooDao.insertData();
        fooDao.listData();
        batchFooDao.jdbcBatchInsert();
        fooDao.insertData();
        batchFooDao.namedParameterJdbcBatchInsert();
        fooDao.listData();
    }
}
