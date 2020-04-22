package com.anigy.spring07errorcodesdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring07ErrorcodesDemoApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test(expected = CustomDuplicatedKeyException.class)
    public void contextLoads() {
        jdbcTemplate.execute("INSERT INTO FOO ( ID, BAR ) VALUES ( '1', 'A' )");
        jdbcTemplate.execute("INSERT INTO FOO ( ID, BAR ) VALUES ( '1', 'B' )");
    }

}
