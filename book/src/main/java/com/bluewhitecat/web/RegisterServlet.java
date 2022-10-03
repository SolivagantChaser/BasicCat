package com.bluewhitecat.web;

import com.bluewhitecat.pojo.User;
import com.bluewhitecat.service.UserService;
import com.bluewhitecat.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

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
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 验证码错误
        if(! "abcde".equalsIgnoreCase(code)) {
            System.out.println("验证码" + code + "错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

        // 用户名已存在
        if (userService.isExistedUser(userName)) {
            System.out.println("用户名" + userName + "已存在");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

        // 注册用户
        userService.registerUser(new User(null, userName, password, email));
        req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
    }
}
