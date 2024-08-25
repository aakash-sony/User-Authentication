package com.nit.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.nit.bean.UserBean;
import com.nit.dao.UpdateProfileDao;

@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie ck[] = request.getCookies();
		if (ck == null) {
			request.setAttribute("msg", "Session Expired..<br>");
			request.getRequestDispatcher("Msg.jsp").forward(request, response);
		} 
		else 
		{
			String fn = ck[0].getValue();
			request.setAttribute("fname", fn);

			ServletContext sct = request.getServletContext();

			UserBean ub = (UserBean) sct.getAttribute("ubean");

			ub.setAddress(request.getParameter("address"));
			ub.setmId(request.getParameter("mId"));
			ub.setPhoneNum(Long.parseLong(request.getParameter("phoneNum")));
			int k = new UpdateProfileDao().update(ub);
			if (k > 0) {
				request.setAttribute("msg", "Profile updated successfully..");
				request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
			}

		}

	}

}
