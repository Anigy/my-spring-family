package com.anigy.spring08transactionpropagationdemo;

public interface FooService {
    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollBack();
}
