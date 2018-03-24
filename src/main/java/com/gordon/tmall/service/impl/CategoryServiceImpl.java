package com.gordon.tmall.service.impl;

import com.gordon.tmall.mapper.CategoryMapper;
import com.gordon.tmall.pojo.Category;
import com.gordon.tmall.pojo.CategoryExample;
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

    //项目重构list(Page page)解偶
    //@Override
    //public List<Category> list(Page page) {
    //    return categoryMapper.list(page);
    //}
    
    //去掉total()方法
    //@Override
    //public int total() {
    //    return categoryMapper.total();
    //}


    /**
     * 传递一个example对象，这个对象指定按照id倒排序来查询
     */
    @Override
    public List<Category> list() {
        
        CategoryExample example =new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }
    
    @Override
    public void delete(int id){
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
    
    /**
     * updateByPrimaryKeySelective，其作用是只修改变化了的字段，未变化的字段就不修改了。
     * @param category
     */
    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }


}
