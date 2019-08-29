package com.anigy.jpa.spring11jpademo.repository;

import com.anigy.jpa.spring11jpademo.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
