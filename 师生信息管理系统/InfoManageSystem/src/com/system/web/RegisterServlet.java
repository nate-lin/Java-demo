package com.system.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.dao.UserDao;
import com.system.model.User;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

public class RegisterServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		if(password.equals(repassword)){
            //把用户消息放进session中
            HttpSession session = request.getSession();
            session.setAttribute("userName",userName);
            session.setAttribute("password",password);
           response.sendRedirect("success.jsp");
            //request.getRequestDispatcher("success.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("pwdFail","yes");
            response.sendRedirect("register.jsp");
        }
		
	}

	
}
