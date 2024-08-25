package com.nit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int x =0;
		Cookie ck[] = request.getCookies();
		for (Cookie cookie: ck) 
		{
			if(cookie.getName().equals("fName"))
			{
				x++;
				break;
			}
		
		}
		if(x==0){
			response.sendRedirect("login.html");
			return;
		}
		
		if(ck == null)
		{
			request.setAttribute("msg", "Session Expired..<br>");
			request.getRequestDispatcher("Msg.jsp").forward(request, response);
		}
		else
		{
			for (Cookie cookie : ck) {
				if (cookie.getName().equals("fName")) {
					String fn = cookie.getValue();
					request.setAttribute("fname", fn);
					request.getRequestDispatcher("ViewProfile.jsp").forward(request, response);
					break;
			    }
			}
		}
	}
}
