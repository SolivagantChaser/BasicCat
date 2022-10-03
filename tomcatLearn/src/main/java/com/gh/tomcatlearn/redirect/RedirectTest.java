package com.gh.tomcatlearn.redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectTest extends HttpServlet {
    /**
     * 请求重定向是指客户端给服务器发送请求，然后服务器告诉客户端新的地址去请求 响应码302
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方式一
        System.out.println("到此一游：Redirect");
        // 设置响应状态码302，表示重定向
        resp.setStatus(302);
        // 设置新的响应头，说明新的地址在哪里
        resp.setHeader("Location", "http:localhost:8080/response");

        /**
         * 方式二：
         * resp.sendRedirect("http:localhost:8080/response");
         */
    }
    /**
     * 重定向特点
     * 1、浏览器地址栏会发生变化
     * 2、两次请求
     * 3、不共享response域的数据
     * 4、不能访问web-inf的资源
     * 5、可以访问外部资源
     */
}
