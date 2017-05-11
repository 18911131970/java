package com.service;

import com.dao.VisitDao;
import com.entity.Visit;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangzhe on 2017/5/10.
 */
@Transactional
public class VisitService {

    private VisitDao visitDao;
    public void setVisitDao(VisitDao visitDao) {
        this.visitDao = visitDao;
    }


    public void add(Visit visit) {
        visitDao.add(visit);
    }
}
