package com.anigy.spring05declarativetransactiondemo;

public interface FooService {
    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;

    long getCount(String value);
}
