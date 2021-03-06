package com.ycw.photosystem.service;

import com.ycw.photosystem.dao.mysql.CategoryDAO;
import com.ycw.photosystem.dao.mysql.PictureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    PictureDAO pictureDAO;

    public List getAll() {
        return categoryDAO.findAll();
    }

    public Long getPictureCount(int categoryId) {
        return pictureDAO.findSumByCategoryId(categoryId);
    }
}
