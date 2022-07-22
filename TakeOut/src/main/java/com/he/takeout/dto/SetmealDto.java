package com.he.takeout.dto;

import com.he.takeout.pojo.Setmeal;
import com.he.takeout.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
