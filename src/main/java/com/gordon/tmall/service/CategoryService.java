package com.gordon.tmall.service;

import com.gordon.tmall.pojo.Category;

import java.util.List;

/**
 * @author gordon
 */
public interface CategoryService {
    
    
    //项目重构
    // 去除多余的public List<Category> list(Page page);
    // 去除total()
    
    List<Category> list();
    
    //int total();
    
    void add(Category category);
    
    void delete(int id);
    
    Category get(int id);

    void update(Category category);
}
