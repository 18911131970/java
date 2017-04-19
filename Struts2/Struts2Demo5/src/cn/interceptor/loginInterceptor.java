package cn.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangzhe on 2017/4/19.
 * 拦截器
 */
public class loginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = (String)request.getSession().getAttribute("username");
        String password = (String)request.getSession().getAttribute("password");

        //aop思想
        if (username != null && password != null) {
            //登录成功  做类似于放行的操作
            return  actionInvocation.invoke();
        } else  {
            //不是登录状态
            //回到登录状态
            return "login";
        }
    }
}
