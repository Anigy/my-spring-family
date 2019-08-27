package com.anigy.spring08transactionpropagationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FooServiceImpl implements FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor = RollbackException.class, propagation = Propagation.NESTED)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ( 'BBB' )");
//        throw new RollbackException();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void invokeInsertThenRollBack(){
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ( 'AAA' )");
        try {
            insertThenRollback();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
