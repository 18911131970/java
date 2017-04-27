package cn.form;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangzhe on 17/4/18.
 */
public class form2 extends ActionSupport {

    @Override
    public String execute() throws Exception {

//        HttpServletRequest request = ServletActionContext.getRequest();
//        //调用request
//
//        Map<String, String[]> map = request.getParameterMap();
//
//        Set<String> keys = map.keySet();
//
//        for (String key:keys){
//            Object[] objects = (Object[]) map.get(key);
//            System.out.println("key:" + key + Arrays.toString(objects));
//        }


        //域对象的操作
        //request 域
        HttpServletRequest request = ServletActionContext.getRequest();

        //session域
        HttpSession session = request.getSession();
        session.setAttribute("sess","sessionValue");

        //ServletContext 域
        ServletContext context = ServletActionContext.getServletContext();
        context.setAttribute("contextName","contextValue");


        return NONE;
    }
}
