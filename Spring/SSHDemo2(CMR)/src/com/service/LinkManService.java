package com.service;

import com.dao.LinkManDao;
import com.entity.LinkMan;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangzhe on 2017/5/3.
 */
@Transactional
public class LinkManService {
    private LinkManDao linkManDao;
    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    public void addLinkMan(LinkMan linkMan){
        linkManDao.addLinkMan(linkMan);
    }
}
