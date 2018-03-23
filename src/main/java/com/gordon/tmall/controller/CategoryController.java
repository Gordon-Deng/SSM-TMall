package com.gordon.tmall.controller;

import com.gordon.tmall.pojo.Category;
import com.gordon.tmall.service.CategoryService;
import com.gordon.tmall.util.ImageUtil;
import com.gordon.tmall.util.Page;
import com.gordon.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
     * @param model
     * @param page
     * @return
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


    /**
     * add方法映射路径admin_category_add的访问
     * @param category
     * @param session
     * @param uploadedImageFile
     * @return
     * @throws IOException
     */
    @RequestMapping("admin_category_add")
    public String add(Category category, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        
        //参数 Category category接受页面提交的分类名称
        categoryService.add(category);
        //参数 session 用于在后续获取当前应用的路径
        File imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        //图片不入库，拼接属性ID和图片名成一个新文件，供Jsp解析
        File file = new File(imageFolder,category.getId()+".jpg");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        
        //通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/admin_category_list";
    }


    /**
     * 映射路径admin_category_delete
     * @param id
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("admin_category_delete")
    public String delete(int id, HttpSession session)throws IOException{
        categoryService.delete(id);
        
        //通过session获取ControllerContext然后获取分类图片位置，接着删除分类图片
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        //拼接图片名
        File file = new File(imageFolder, id+".jpg");
        file.delete();
        
        //客户端跳转到 admin_category_list
        return "redirect:/admin_category_list";
    }
    
}
