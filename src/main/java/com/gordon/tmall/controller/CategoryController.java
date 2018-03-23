package com.gordon.tmall.controller;

import com.gordon.tmall.pojo.Category;
import com.gordon.tmall.service.CategoryService;
import com.gordon.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * 注解@Controller声明当前类是一个控制器
 * 注解@RequestMapping("")表示访问的时候无需额外的地址
 * @author gordon
 */
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 注解@RequestMapping("admin_category_list") 映射admin_category_list路径的访问
     * 在list方法中，通过categoryService.list()获取所有的Category对象，然后放在"cs"中，并服务端跳转到 “admin/listCategory” 视图。
     */
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        List<Category> cs= categoryService.list(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
    
}
