package cn.form;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by yangzhe on 17/4/18.
 */
public class form1 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        //actionContext方式
        //1、获取ActionContext对象
        ActionContext context = ActionContext.getContext();

        //2、调用方法获取表单数据
        //key:表单中那么值
        Map<String,Object> map = context.getParameters();

        Set<String> keys = map.keySet();

        for (String key:keys){
            Object[] objects = (Object[]) map.get(key);
            System.out.println("key:" + key + Arrays.toString(objects));
        }
        return NONE;
    }
}
