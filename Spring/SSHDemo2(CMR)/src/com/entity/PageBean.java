package com.entity;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/3.
 */
public class PageBean {
    private Integer currentPage;
    private Integer totalCount;
    private Integer pageSize;
    private Integer totalePage;
    private Integer begin;
    //每页记录的集合
    private List<Customer> list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalePage() {
        return totalePage;
    }

    public void setTotalePage(Integer totalePage) {
        this.totalePage = totalePage;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }
}
