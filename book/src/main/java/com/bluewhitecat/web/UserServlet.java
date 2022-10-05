package com.bluewhitecat.web;

import com.bluewhitecat.pojo.User;
import com.bluewhitecat.service.UserService;
import com.bluewhitecat.service.impl.UserServiceImpl;
import com.bluewhitecat.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 1、获取请求参数
     * 2、检查验证码是否正确
     * 正确
     * 3、检查用户名是否可用
     * 可以
     * 调用service保存到数据库
     * 跳到注册成功页面
     * 不可以
     * 跳回注册页面
     * 不正确
     * 跳回注册页面
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + Arrays.asList(entry.getValue()));
        }

        // 验证码错误
        if (!"abcde".equalsIgnoreCase(code)) {
            req.setAttribute("msg", "验证码错误");
            System.out.println("验证码" + code + "错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

        // 用户名已存在
        if (userService.isExistedUser(userName)) {
            req.setAttribute("username", "用户名已存在");
            req.setAttribute("email", email);
            System.out.println("用户名" + userName + "已存在");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

        // 注册用户
        userService.registerUser(new User(null, userName, password, email));
        req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
    }

    /**
     * 1、获取请求参数
     * 2、检查验证码是否正确
     * 正确
     * 3、检查用户名是否可用
     * 可以
     * 调用service保存到数据库
     * 跳到注册成功页面
     * 不可以
     * 跳回注册页面
     * 不正确
     * 跳回注册页面
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request_url = req.getHeader("Request URL");
        System.out.println(request_url);
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, userName, password, null));
        if (loginUser == null) {
            System.out.println("登录失败");
            // 把错误信息和回显的表单项信息保存到request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", userName);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
