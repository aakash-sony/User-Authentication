package com.nit.controller;

import com.nit.bean.UserBean;
import com.nit.dao.RegisterDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean ub = new UserBean();

		ub.setUserName(request.getParameter("uName"));
		ub.setPassword(request.getParameter("pWord"));
		ub.setfName(request.getParameter("fName"));
		ub.setlName(request.getParameter("lName"));
		ub.setAddress(request.getParameter("address"));
		ub.setmId(request.getParameter("mId"));
		ub.setPhoneNum(Long.parseLong(request.getParameter("phoneNum")));
		
		RegisterDao rsd = new RegisterDao();
		int k = rsd.register(ub);

		if(k > 0)
		{
			request.setAttribute("message", "User registered successfully...<br>");
			RequestDispatcher rd = request.getRequestDispatcher("RegSuccess.jsp");
			rd.forward(request, response);
		}

	}

}
