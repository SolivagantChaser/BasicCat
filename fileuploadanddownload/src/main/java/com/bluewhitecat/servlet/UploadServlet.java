package com.bluewhitecat.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {

    /**
     * 用来处理上传的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        // 判断上传的数据是否为多段数据（只有多段数据，才是文件上传的）
        if(! ServletFileUpload.isMultipartContent(req)) {
            throw new ServletException("not file upload");
        }

        // 创建FileItemFactory实现类
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        // 创建用于解析上传数据的工具类ServletFileUpload对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        try {
            // 解析上传的数据，得到每一个表单项FileItem
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);

            for (FileItem fileItem : fileItems) {
                if(fileItem.isFormField()) {
                    // 普通表单项
                    System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                    System.out.println("表单项的value值：" + fileItem.getString("UTF-8"));
                } else {
                    // 上传的文件
                    System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                    System.out.println("上传的文件名：" + fileItem.getFieldName());
                    fileItem.write(new File("/Users/guohang/Desktop"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
