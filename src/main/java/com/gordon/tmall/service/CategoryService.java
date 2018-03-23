package com.gordon.tmall.service;

import com.gordon.tmall.pojo.Category;
import com.gordon.tmall.util.Page;

import java.util.List;

/**
 * @author gordon
 */
public interface CategoryService {
    
    List<Category> list(Page page);
    int total();
    void add(Category category);
    void delete(int id);
}
