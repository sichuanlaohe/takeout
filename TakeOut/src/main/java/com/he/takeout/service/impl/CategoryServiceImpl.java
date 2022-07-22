package com.he.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.takeout.common.CustomException;
import com.he.takeout.mapper.CategoryMapper;
import com.he.takeout.pojo.Category;
import com.he.takeout.pojo.Dish;
import com.he.takeout.pojo.Setmeal;
import com.he.takeout.service.CategoryService;
import com.he.takeout.service.DishService;
import com.he.takeout.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(long id){
        LambdaQueryWrapper<Dish> dishQueryWrapper=new LambdaQueryWrapper<>();
        dishQueryWrapper.eq(Dish::getCategoryId,id);
        int count=dishService.count(dishQueryWrapper);
        if(count>0){
            throw new CustomException("关联了菜品，不能删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper=new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2=setmealService.count(setmealLambdaQueryWrapper);
        if(count2>0){
            throw new CustomException("关联了套餐，不能删除");
        }
        super.removeById(id);
    }
}
