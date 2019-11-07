package com.anigy.spring13mybatisdemo.mapper;

import com.anigy.spring13mybatisdemo.model.Coffee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Classname CoffeeMapper
 * @Description TODO
 * @Date 2019/9/3 8:40
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
@Mapper
public interface CoffeeMapper {
    @Insert("insert into t_coffee ( name, price, create_time, update_time)"
             + "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime"),
            // 如果配置了map-underscore-to-camel-case可以自动实现连字符到驼峰的转换，不需要上面这两行
    })
    Coffee findById(@Param("id") Long id);
}
