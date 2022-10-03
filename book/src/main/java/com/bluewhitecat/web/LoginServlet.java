package com.bluewhitecat.web;

import com.bluewhitecat.pojo.User;
import com.bluewhitecat.service.UserService;
import com.bluewhitecat.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 1、获取请求参数
     * 2、检查验证码是否正确
     *  正确
     *      3、检查用户名是否可用
     *          可以
     *              调用service保存到数据库
     *              跳到注册成功页面
     *          不可以
     *              跳回注册页面
     *  不正确
     *      跳回注册页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, userName, password, null));
        if(loginUser == null) {
            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
