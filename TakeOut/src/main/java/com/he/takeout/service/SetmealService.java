package com.he.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.takeout.dto.SetmealDto;
import com.he.takeout.pojo.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);
    public void removeWithDish(List<Long> ids);
}
