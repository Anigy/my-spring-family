package com.anigy.spring00demofortesst;

import org.junit.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonTests {
    @Test
    public void dateConvert() throws ParseException {
        List<String> date = Arrays.asList("2018-11-01", "2018-11-22", "2019-02-01", "2019-02-28", "2019-02-12", "2019-02-12", "2019-03-12", "2019-03-13", "2019-08-22", "2019-09-22", "2019-09-23", "2019-09-28", "2019-09-29");
        for (String d : date) {
            long startMillis = DateTranstlateUtils.strToDate(d + DateTranstlateUtils.MIN_TIME, null).getTime();
            System.out.println(d + "  :  " + startMillis);
        }

        Map<String, HashMap<String, Integer>> map = new HashMap<>();
        map.put("1", null);
        for(Map.Entry<String, Integer> entry : map.get("1").entrySet()) {
            ;
        }


        System.out.println("test finished");

    }
}
