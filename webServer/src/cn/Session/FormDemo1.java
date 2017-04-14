package cn.Session;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by yangzhe on 17/4/12.
 */
public class FormDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TokenProcessor tp = TokenProcessor.getInstance();
        String token = tp.generateToke();

        req.getSession().setAttribute("token",token);
        req.getRequestDispatcher("/form.jsp").forward(req,resp);
    }
}
/*单例获取token*/
class TokenProcessor {
    private TokenProcessor(){};
    private static  final TokenProcessor instance = new TokenProcessor();
    public  static TokenProcessor    getInstance(){
        return instance;
    }
    public String generateToke(){
        String token = System.currentTimeMillis() + new Random().nextInt() + "";

        try {
            //数据的摘要  获取等长度的token
            MessageDigest md =  MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(token.getBytes());
            /*
              转为base64－－》base64中
              取6位作为一个字节前面补0组成8位
              值从0-－－63之间
              00000000---00111111
             */
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);

        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException();
        }

    }
}
