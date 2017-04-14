package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by yangzhe on 17/4/7.
 *
 * 下载一个服务器文件
 */
public class Servlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //

        String filePath = this.getServletContext().getRealPath("/download/海贼王.jpeg");
        String fileName = filePath.substring((filePath.lastIndexOf("/") + 1));
        System.out.println(fileName);
        //如果下载文件为中文文件名  通过url编码
        resp.setHeader("Content-disposition",("attachment;filename=" + URLEncoder.encode(fileName,"UTF-8")));
        InputStream in = null;
        OutputStream out = null;
        try {

            in = new FileInputStream(filePath);
            byte buffer[] = new byte[1024];
            out = resp.getOutputStream();
            int len = 0;
            while ((len = in.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if (in != null)in.close();
            if (out != null)out.close();
        }




    }

    public void test1(HttpServletResponse resp, String filePath) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        BufferedOutputStream bufOut = null;
        BufferedInputStream bufIn = null;

        try {
            in = new FileInputStream(filePath);


            bufIn = new BufferedInputStream(in);

            int len = 0;
            out = resp.getOutputStream();
            bufOut = new BufferedOutputStream(out);

            while ((len = bufIn.read()) != -1){
                bufOut.write(len);
            }
        } finally {
             if (bufIn != null)bufIn.close();

             if (bufOut != null)bufOut.close();
        }
    }
}
