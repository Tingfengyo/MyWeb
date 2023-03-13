package com.Tsing.servlet;

/**
 * @author tingfeng
 * @date 2023/3/10 19:16
 */

import com.Tsing.Dao.UserDao;
import com.Tsing.Dao.impl.UserDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // TODO: Check if the username and password are valid

        if (new UserDaoImpl().loginSystem(username,password)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("</body></html>");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}