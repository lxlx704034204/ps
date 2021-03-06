package com.ycw.photosystem.controller;

import com.ycw.photosystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("getAllCategory")
    @ResponseBody
    public List getAllCategory() {
        return categoryService.getAll();
    }

    @RequestMapping("getPicSumInCat")
    @ResponseBody
    public Long getPicSumInCat(int categoryId) {
        return categoryService.getPictureCount(categoryId);
    }
}
