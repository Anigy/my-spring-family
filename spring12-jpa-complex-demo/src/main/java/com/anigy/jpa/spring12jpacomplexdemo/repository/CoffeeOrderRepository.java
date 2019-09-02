package com.anigy.jpa.spring12jpacomplexdemo.repository;

import com.anigy.jpa.spring12jpacomplexdemo.model.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    List<CoffeeOrder> findByCustomerOrderByIdDesc(String customer);
    List<CoffeeOrder> findByItems_Name(String name);
}
