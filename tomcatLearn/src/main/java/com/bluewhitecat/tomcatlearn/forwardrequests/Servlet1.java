package com.bluewhitecat.tomcatlearn.forwardrequests;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String userName = req.getParameter("username");
        System.out.println("在servlet1获取username " + userName);
        // 传递到servlet2
        req.setAttribute("key", "servlet1");
        /**
         * 请求转发必须以斜杠开头，斜杠表示地址为：http://ip:port/工程名/
         * 映射到代码的web目录
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        requestDispatcher.forward(req, resp);
    }
}
