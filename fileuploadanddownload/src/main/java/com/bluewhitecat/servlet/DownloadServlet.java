package com.bluewhitecat.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 1、获取要下载的文件名
 * 2、读取要下载的文件内容
 * 3、把下载的文件内容回传给客户端
 * 4、在回传前，通过响应头告诉客户端返回的数据类型
 * 5、还要告诉给客户端收到的数据是用于下载使用
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String downloadFileName = "2.png";
        ServletContext servletContext = getServletContext();
        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println(mimeType);
        if(req.getHeader("User-Agent").contains("Firefox")) {
            // base64 encode
        } else {
            // url encode
        }
        // 回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        // 表示下载使用
        resp.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);
        // 斜杠/被服务器解析表示地址为http://ip:port/工程名/ 映射到代码的web目录
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        // 获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        // 读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
