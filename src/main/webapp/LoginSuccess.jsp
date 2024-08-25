<%@page import="com.nit.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<%
	UserBean ub = (UserBean) application.getAttribute("ubean");

	out.println("Welcome user: " + ub.getfName() + "<br>");
	%>
	<a href="view">View Profile</a><br>
	<a href="logout">Logout</a>
</body>
</html>