package com.he.takeout.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.takeout.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
