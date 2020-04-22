package com.anigy.spring00demofortesst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring00DemoForTesstApplicationTests {

    @Test
    public void contextLoads() {
        Map<String, Map<String,String>> map = new HashMap();
        Set<String> s = map.getOrDefault("a", new HashMap<>()).keySet();
        System.out.println("Done!");
    }
}
