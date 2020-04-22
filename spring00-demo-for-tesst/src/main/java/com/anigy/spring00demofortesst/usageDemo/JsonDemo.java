package com.anigy.spring00demofortesst.usageDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class JsonDemo {

    public String getJsonStringAttribute(String attributeData, String attributeKey) {
        String result = "";
        JSONArray jsonArray = JSON.parseArray(attributeData);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (attributeKey.equals(jsonObject.getString("attributeKey"))) {
                result = jsonObject.getJSONObject("attributeValue").toString();
            }
        }
        return result;
    }


}
