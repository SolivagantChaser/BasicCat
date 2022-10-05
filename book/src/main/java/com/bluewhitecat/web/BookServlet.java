package com.bluewhitecat.web;

import com.bluewhitecat.pojo.Book;
import com.bluewhitecat.service.BookService;
import com.bluewhitecat.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/manager/bookServlet")
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1、通过BookService查询全部图书
         * 2、把全部图书保存到Request域中
         * 3、请求转发到/pages/manager/book_manager.jsp
         */
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.js").forward(req, resp);
    }
}
