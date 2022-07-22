package com.he.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.takeout.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CategoryService extends IService<Category> {
    public void remove(long id);
}
