package com.gordon.tmall.service.impl;

import com.gordon.tmall.mapper.CategoryMapper;
import com.gordon.tmall.pojo.Category;
import com.gordon.tmall.service.CategoryService;
import com.gordon.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 注解@Service声明当前类是一个Service类
 * 通过自动装配@Autowired引入CategoryMapper ，在list方法中调用CategoryMapper 的list方法.
 * @author gordon
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }

    @Override
    public int total() {
        return categoryMapper.total();
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }
    
    @Override
    public void delete(int id){
        categoryMapper.delete(id);
    }


}
