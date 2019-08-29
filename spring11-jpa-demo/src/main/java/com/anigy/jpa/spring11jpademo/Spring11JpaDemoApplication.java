package com.anigy.jpa.spring11jpademo;

import com.anigy.jpa.spring11jpademo.model.Coffee;
import com.anigy.jpa.spring11jpademo.model.CoffeeOrder;
import com.anigy.jpa.spring11jpademo.repository.CoffeeOrderRepository;
import com.anigy.jpa.spring11jpademo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Spring11JpaDemoApplication implements CommandLineRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring11JpaDemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        initOrders();
    }

    private void initOrders() {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeRepository.save(espresso);
        log.info("Coffee: {}", espresso);

        Coffee latte = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);
        log.info("Latte: {}", latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Anigy")
                .items(Arrays.asList(espresso, latte))
                .state(0)
                .build();
        coffeeOrderRepository.save(order);
        log.info("Order: {}", order);

    }
}
