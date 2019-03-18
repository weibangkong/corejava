package com.kwb.fileupload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //获得上传附件
        Part part = req.getPart("photo");
        if (part != null && part.getSubmittedFileName().length() > 0) {
            //获得上传文件夹的绝对路径
            String savePath = req.getServletContext().getRealPath("upload");
            part.write(savePath +"/"+ part.getSubmittedFileName());
            req.setAttribute("hint", "upload successfully");
        } else {
            req.setAttribute("hint","upload failed");
        }
        //重定向回原来上传页面
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
