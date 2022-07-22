package com.he.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.takeout.dto.DishDto;
import com.he.takeout.pojo.Dish;
import org.springframework.stereotype.Service;

@Service
public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);
    public DishDto getOneWithFlavor(Long id);
    public void editWithFlavor(DishDto dishDto);
}
