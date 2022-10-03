package com.bluewhitecat.tomcatlearn;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet生命周期
 * 1、执行Servlet构造器方法
 * 2、执行init方法
 * 3、执行service方法
 * 4、执行destroy销毁方法
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 专门用来处理请求和响应
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.Hello Servlet 被访问");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if("doGet".equals(method)) {
            doGet();
        } else if("doPost".equals(method)) {
            doPost();
        }
    }

    public static void doGet() {
        System.out.println("it is get request");
    }

    public static void doPost() {
        System.out.println("it is post request");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy销毁方法");
    }
}