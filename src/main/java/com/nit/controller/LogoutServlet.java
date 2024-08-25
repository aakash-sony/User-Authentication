package com.nit.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck[] = request.getCookies();
		if(ck==null)
		{
			request.setAttribute("msg", "Session Expired...<br>");
		}
		else
		{
			ServletContext sct = request.getServletContext();
			sct.removeAttribute("ubean");
			ck[0].setMaxAge(0);
			response.addCookie(ck[0]);
			request.setAttribute("msg", "User Logged Out Successfully...");
		}
		request.getRequestDispatcher("Msg.jsp").forward(request, response);;
	}
}
