package com.gh.tomcatlearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置服务器字符集为UTF-8
        resp.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也使用UTF-8字符集
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        /**
         * resp.setContentType("text/html; charset=UTF-8");
         * 会同时设置服务器与客户端的字符集为UTF-8，还设置了响应头
         */

        PrintWriter writer = resp.getWriter();// 字符流
        writer.write("response is connect");

        System.out.println(resp.getCharacterEncoding());
        writer.write("国庆");

        // resp.getOutputStream();     // 字节流
        /**
         * 字节流与字符流同时只能使用一个
         * 使用了字节流，就不能再使用字符流，反之亦然，否则会报错
         */

    }
}
