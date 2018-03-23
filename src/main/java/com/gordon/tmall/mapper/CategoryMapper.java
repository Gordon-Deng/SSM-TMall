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
    public List<Category> list(Page page);
    
    public int total();
    
    void add(Category category);
}
