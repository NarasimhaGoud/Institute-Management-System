<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>h6{color:red;}</style>
</head>
<body>
<form action="savestudent" method="post">
<center>
<h5> Insert Data </h5>
<label>Name     :</label><input type="text" name="txtname"/><br><br>
<label>Age      :</label><input type="number" name="txtage"/><br><br>
<label>Mobile   :</label><input type="number" name="txtmobile"/><br><br>
<label>Address  :</label><input type="text" name="txtaddress"/><br><br>
<label>Email    :</label><input type="email" name="txtemail"/><br><br>
<label>Course   :</label><input type="text" name="txtcourse"/><br><br>
<% if(request.getAttribute("message")!=null){
	out.println("<h6>"+request.getAttribute("message")+"<h6>");
}

%>
<input type ="submit" style="color:green;"value="Save"/>
</center>
</body>
</html>