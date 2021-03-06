package com.ycw.photosystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ycw.photosystem.bean.es.PictureEsBean;
import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.dao.es.PictureEsDAO;
import com.ycw.photosystem.dao.mysql.PictureDAO;
import com.ycw.photosystem.dao.tranform.PictureTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TestService {

    private final PictureDAO pictureDAO;
    private final PictureEsDAO pictureEsDAO;
    private final PictureTransform pictureTransform;

    @Autowired
    public TestService(PictureDAO pictureDAO, PictureEsDAO pictureEsDAO, PictureTransform pictureTransform) {
        this.pictureDAO = pictureDAO;
        this.pictureEsDAO = pictureEsDAO;
        this.pictureTransform = pictureTransform;
    }

    public Picture findById(Long id) {
        return pictureDAO.findById(id);
    }

    public List findByIds(Long[] ids) {
        return pictureDAO.findByIds(ids);
    }

    public List findByIdsDecs(Long[] ids) {
        return pictureDAO.findByIds(ids, false);
    }



    public void save(Picture picture) {
        pictureDAO.save(picture);
    }

    public void oneUpdate(Picture picture){
        PictureEsBean pictureEsBean = pictureTransform.transform(picture);
        try {
            pictureEsDAO.index(pictureEsBean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void totalUpdate() {
        Long endId = pictureDAO.findMaxId();
        Long startId = pictureDAO.findMinId();
        int perCount = 10;
        while (startId < endId) {
            List list = pictureDAO.findFromTO(startId, startId + perCount);
            startId = startId + perCount;
            for (Object o : list) {
                Picture p = (Picture) o;
                try {
                    pictureEsDAO.index(pictureTransform.transform(p));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

