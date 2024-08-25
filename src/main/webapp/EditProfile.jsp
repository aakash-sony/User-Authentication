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
String fN = (String)request.getAttribute("fname");
UserBean ub = (UserBean)application.getAttribute("ubean");
out.println("Page belongs to user: "+ub.getfName()+"<br>");
%>
<form action="update" method="post">
Address:<input type="text" name="address" value=<%=ub.getAddress() %>><br>
Mail Id:<input type ="email" name="mId" value=<%=ub.getmId()%>><br>
Mobile:<input type ="tel" name="phoneNum" value=<%=ub.getPhoneNum()%>><br>
<input type="submit" value="Update Profile">
</form>
</body>
</html>