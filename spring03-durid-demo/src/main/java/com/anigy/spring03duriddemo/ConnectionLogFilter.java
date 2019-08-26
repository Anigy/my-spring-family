package com.anigy.spring03duriddemo;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @Classname ConnectionLogFilter
 * @Description TODO
 * @Date 2019/8/26 8:46
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */

@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {
    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("BEFORE CONNECTION!");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connectionProxy) {
        log.info("AFTER CONNECTION");
    }
}
