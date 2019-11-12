package com.anigy.spring15mybatispagehelperdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * @Classname Coffee
 * @Description TODO
 * @Date 2019/11/12 23:51
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
