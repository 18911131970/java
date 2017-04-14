package cn.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by yangzhe on 17/4/7.
 */
public class Servlet6 extends HttpServlet {


    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        setBackground(g);
        setBorder(g);
        //设置干扰线
        drawLine(g);
        //写入随机数
        drawRandomNum((Graphics2D)g);
        //写给浏览器
        resp.setContentType("image/jpeg");
        //控制浏览器不要缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        ImageIO.write(image,"jpg",resp.getOutputStream());




    }

    /*边框*/
    public void drawLine(Graphics g){
        g.setColor(Color.green);
        for (int i = 0; i < 5; i++) {

            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);

            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine(x1,y1,x2,y2);
        }
    }
    //随机数
    public void drawRandomNum(Graphics2D g) {

        g.setColor(Color.blue);
        g.setFont(new Font("宋体",Font.BOLD,20));
        //汉子 \u4e00 -- \u9fa5
        int x1 = 10;
        for (int i = 0; i < 4; i++) {

            String num = new Random().nextInt(9) + "";
//            g.drawBytes(num.getBytes(),0,num.length(),x1,y1);
            int degree = new Random().nextInt() % 30;

            g.drawString(num,x1,30);
//            g.rotate((Math.PI / 180 * degree),x1,10);
            x1 += 20;

        }
    }
    //设置背景颜色
    public void setBackground(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }
    //设置边框
    public void setBorder(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(1,1,WIDTH - 4,HEIGHT - 4);
    }
}
