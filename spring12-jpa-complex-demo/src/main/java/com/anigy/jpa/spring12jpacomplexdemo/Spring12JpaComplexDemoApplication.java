package com.anigy.jpa.spring12jpacomplexdemo;

import com.anigy.jpa.spring12jpacomplexdemo.model.Coffee;
import com.anigy.jpa.spring12jpacomplexdemo.model.CoffeeOrder;
import com.anigy.jpa.spring12jpacomplexdemo.model.OrderState;
import com.anigy.jpa.spring12jpacomplexdemo.repository.CoffeeOrderRepository;
import com.anigy.jpa.spring12jpacomplexdemo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories
@EnableTransactionManagement
public class Spring12JpaComplexDemoApplication implements ApplicationRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring12JpaComplexDemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        initOrders();
        addSomeData();
        findOrders();
    }

    private void initOrders() {
        Coffee latte1 = Coffee.builder()
                .name("latte1")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.00))
                .build();
        Coffee c1 = coffeeRepository.save(latte1);
        Long latteId = c1.getId();
        log.info("Coffee latte: {}", coffeeRepository.findById(latteId));

        Coffee espresso1 = Coffee.builder()
                .name("espresso1")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.00))
                .build();
        Coffee c2 = coffeeRepository.save(espresso1);
        Long espressoId = c2.getId();
        log.info("Coffee espresso: {}", coffeeRepository.findById(espressoId));

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Anigy")
                .items(Collections.singletonList(espresso1))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);
//        log.info("Anigy's order: {}", order);

        order = CoffeeOrder.builder()
                .customer("Donna")
                .items(Arrays.asList(latte1, espresso1))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);
//        log.info("Donna's order: {}", order);
    }

    private void findOrders() {
        coffeeRepository
                .findAll(Sort.by(Sort.Direction.DESC, "id"))
                .forEach(c -> log.info("Loading coffee {}", c));

        coffeeOrderRepository
                .findAll()
                .forEach(o -> log.info("Loading order {}", o));

        List<CoffeeOrder> list = coffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
        log.info("findTop3ByOrderByUpdateTimeDescIdAsc, result with id: {}", getJoinedOrderId(list));

        list = coffeeOrderRepository.findByCustomerOrderByIdDesc("Anigy");
        log.info("findByCustomerOrderByIdDesc for Anigy: {}", getJoinedOrderId(list));

        list.forEach(o -> {
            log.info("Order {}", o.getId());
            o.getItems().forEach(i -> log.info("  Item {}", i));
        });

        list = coffeeOrderRepository.findByItems_Name("latte2");
        log.info("findByItems_name: {}", getJoinedOrderId(list));
    }

    private String getJoinedOrderId(List<CoffeeOrder> list) {
        return list.stream().map(c -> c.getId().toString())
                .collect(Collectors.joining(","));
    }

    private void addSomeData() {
        Coffee espresso2 = Coffee.builder()
                .name("espresso2")
                .price(Money.of(CurrencyUnit.of("CNY"), 22.00))
                .build();
        coffeeRepository.save(espresso2);

        Coffee espresso3 = Coffee.builder()
                .name("espresso3")
                .price(Money.of(CurrencyUnit.of("CNY"), 23.00))
                .build();
        coffeeRepository.save(espresso3);

        Coffee espresso4 = Coffee.builder()
                .name("espresso4")
                .price(Money.of(CurrencyUnit.of("CNY"), 24.00))
                .build();
        coffeeRepository.save(espresso4);

        Coffee latte2 = Coffee.builder()
                .name("latte2")
                .price(Money.of(CurrencyUnit.of("CNY"), 32.00))
                .build();
        coffeeRepository.save(latte2);

        Coffee latte3 = Coffee.builder()
                .name("latte3")
                .price(Money.of(CurrencyUnit.of("CNY"), 33.00))
                .build();
        coffeeRepository.save(latte3);

        Coffee latte4 = Coffee.builder()
                .name("latte4")
                .price(Money.of(CurrencyUnit.of("CNY"), 34.00))
                .build();
        coffeeRepository.save(latte4);



        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Arrays.asList(latte2, espresso2))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);

        order = CoffeeOrder.builder()
                .customer("Li Ge")
                .items(Arrays.asList(latte3, espresso3))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);

        order = CoffeeOrder.builder()
                .customer("Han Meimei")
                .items(Collections.singletonList(latte4))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);

        order = CoffeeOrder.builder()
                .customer("Anigy")
                .items(Arrays.asList(latte2, espresso2))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);
    }
}
