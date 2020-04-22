package com.anigy.jpa.spring11jpademo.repository;

import com.anigy.jpa.spring11jpademo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
