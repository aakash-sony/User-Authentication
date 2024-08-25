package com.nit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.nit.bean.UserBean;
import com.nit.dao.LoginDao;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uN = request.getParameter("uName");
		String pW = request.getParameter("pWord");

		LoginDao lgd = new LoginDao();

		UserBean ub = lgd.login(uN, pW);

		if (ub == null) 
		{
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			pw.println("<br> Login Failed!! Try again..");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		} else {
			ServletContext sct = request.getServletContext();
			sct.setAttribute("ubean", ub);
			Cookie ck = new Cookie("fName", ub.getfName());
			response.addCookie(ck);

			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(request, response);
		}
	}

}
