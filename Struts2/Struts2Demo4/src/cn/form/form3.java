package cn.form;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangzhe on 17/4/18.
 */
public class form3 extends ActionSupport implements ServletRequestAware {

    HttpServletRequest request = null;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
          this.request = httpServletRequest;
    }

    @Override
    public String execute() throws Exception {

        Map<String, String[]> map = request.getParameterMap();

        Set<String> keys = map.keySet();

        for (String key:keys){
            Object[] objects = (Object[]) map.get(key);
            System.out.println("key:" + key + Arrays.toString(objects));
        }

        return NONE;
    }
}
