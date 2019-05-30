package com.riden.tomtest;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class RidenServlet extends HttpServlet {
    public RidenServlet(){
        System.out.println("running");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("获取请求");
        // 设置本地文字解码
        //request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username:"+username+" password:"+password);
    }


}
