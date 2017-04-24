package cn.xmlAnno;

import javax.annotation.Resource;

/**
 * Created by yangzhe on 2017/4/24.
 */
public class BookService {

    @Resource(name = "bookDao")
    private BookDao bookDao;

    @Resource(name = "orderDao")
    private OrderDao orderDao;


    public void add(){
        System.out.println("BookService------add");
        bookDao.book();
        orderDao.buy();
    }
}
