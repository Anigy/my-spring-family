package com.anigy.spring06simplejdbcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class FooDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public void insertData() {
        Arrays.asList("b", "c").forEach(bar -> {
            jdbcTemplate.update("INSERT INTO FOO (BAR) VALUES (?)", bar);
        });

        Map<String, String> row = new HashMap<>();
        row.put("BAR", "d");
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("ID of d: {}", id.longValue());
        log.info("Total count is: {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO", Long.class));
    }

    public void listData() {
        log.info("Count: {}",
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO", Long.class));

        List<String> list = jdbcTemplate.queryForList("SELECT BAR FROM FOO", String.class);
        list.forEach(s -> log.info("Bar: {}", s));

        // List<Foo> fooList = jdbcTemplate.query("SELECT * FROM FOO", new RowMapper<Foo>() {
        // @Override
        // public Foo mapRow(ResultSet resultSet, int i) throws SQLException {
        // return Foo.builder()
        // .id(resultSet.getLong(1))
        // .bar(resultSet.getString(2))
        // .build();
        // }
        // });
        List<Foo> fooList = jdbcTemplate.query("SELECT * FROM FOO", (resultSet, i) -> Foo.builder()
                .id(resultSet.getLong(1))
                .bar(resultSet.getString(2))
                .build());
        fooList.forEach(foo -> log.info("Foo: {}", foo));
    }

}
