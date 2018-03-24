package com.gordon.tmall.mapper;

import com.gordon.tmall.pojo.Category;
import com.gordon.tmall.util.Page;

import java.util.List;

/**
 * @author gordon
 */
public interface CategoryMapper {
    /**
     * @param page
     * @return List<Category>
     */
    
    //项目重构去除多余的public List<Category> list(Page page);
    List<Category> list();
    
    //public int total();
    
    void add(Category category);
    
    void delete(int id);

    Category edit(int id);

    void update(Category category);
    
}
