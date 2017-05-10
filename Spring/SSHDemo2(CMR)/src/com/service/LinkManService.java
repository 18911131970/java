package com.service;

import com.dao.LinkManDao;
import com.entity.LinkMan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<LinkMan> listLinkMan() {

        return linkManDao.listLinkMan();
    }

    public LinkMan findOne(int linkId) {
        return linkManDao.findOne(linkId);
    }

    public void updata(LinkMan linkMan) {
        linkManDao.updata(linkMan);
    }

    public void delete(LinkMan linkMan) {
        linkManDao.delete(linkMan);
    }
}
