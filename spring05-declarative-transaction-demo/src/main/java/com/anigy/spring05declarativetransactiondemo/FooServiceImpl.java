package com.anigy.spring05declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FooServiceImpl implements FooService {
    @Autowired
    private JdbcTemplate jdbctemplate;

    @Override
    @Transactional
    public void insertRecord() {
        jdbctemplate.execute("INSERT INTO FOO (BAR) VALUES ( 'AAA' )");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbctemplate.execute("INSERT INTO FOO (BAR) VALUES ( 'BBB' )");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
    }

    @Override
    public long getCount(String value) {
        String sql = "SELECT COUNT(*) FROM FOO WHERE BAR = '" + value + "'";
        return jdbctemplate.queryForObject(sql, Long.class);
    }
}
