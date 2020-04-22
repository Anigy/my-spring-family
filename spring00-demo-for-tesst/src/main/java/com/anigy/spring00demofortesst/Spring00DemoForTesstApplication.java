package com.anigy.spring00demofortesst;

import com.anigy.spring00demofortesst.usageDemo.JsonDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring00DemoForTesstApplication implements ApplicationRunner {

    @Autowired
    private JsonDemo jsonDemo;

    public static void main(String[] args) {
        SpringApplication.run(Spring00DemoForTesstApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        // test get jsonObject from json string
        String attributeData = "[\n" +
                "   {\n" +
                "      \"attributeDataId\":0,\n" +
                "      \"attributeKey\":\"decision_maker\",\n" +
                "      \"attributeValue\":\"{\\\"contactEmail\\\":\\\"test@dianping.com\\\",\\\"contactId\\\":1028088,\\\"contactMobile\\\":\\\"18798989891\\\",\\\"contactName\\\":\\\"234\\\",\\\"contactTitle\\\":\\\"法人/董事长\\\",\\\"customerId\\\":976709}\",\n" +
                "      \"productOrderId\":0,\n" +
                "      \"updateTime\":0\n" +
                "   }\n" +
                "]";
        String result = jsonDemo.getJsonStringAttribute(attributeData, "decision_maker");
        System.out.println(result);
    }
}
