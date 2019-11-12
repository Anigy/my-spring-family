package com.anigy.spring15mybatispagehelperdemo.mapper;

import com.anigy.spring15mybatispagehelperdemo.model.Coffee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Classname CoffeeMapper
 * @Description TODO
 * @Date 2019/11/12 23:52
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
@Mapper
public interface CoffeeMapper {
    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}
