package com.anigy.spring13mybatisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * @Classname Coffee
 * @Description TODO
 * @Date 2019/9/3 8:40
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee {
    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
