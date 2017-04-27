package cn.action;

import cn.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

/**
 * Created by yangzhe on 2017/4/24.
 */
public class UserAction extends ActionSupport {

    @Override
    public String execute() throws Exception {

//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext context1 = ContextLoader.getCurrentWebApplicationContext();
        UserService userService = (UserService)context1.getBean("userService");
        userService.add();
        return NONE;
    }
}
