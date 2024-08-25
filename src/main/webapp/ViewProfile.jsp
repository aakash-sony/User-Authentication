<%@page import="com.nit.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int x =0;
		Cookie ck[] = request.getCookies();
		for (Cookie cookie: ck) 
		{
			if(cookie.getName().equals("fName"))
			{
				x++;
			}
		
		}
		if(x==0){
			response.sendRedirect("login.html");
			return;
		}
	%>
	<%
	String fname = (String) request.getAttribute("fname");
	UserBean ub = (UserBean) application.getAttribute("ubean");
	out.println("Page belongs to : " + ub.getfName() + "<br>");
	out.println(ub.getfName() + "&nbsp&nbsp" + ub.getlName() + "&nbsp&nbsp" + ub.getAddress() + "&nbsp&nbsp" + ub.getmId()
			+ "&nbsp&nbsp" + ub.getPhoneNum() +"<br>");
	%>
	<a href="edit">Edit Profile</a>
	<a href="logout">Logout</a>
</body>
</html>