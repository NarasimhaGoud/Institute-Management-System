
<%@page import="com.minproject.bean.Student1"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	<style>body{
background-color:lightblue;
}
	</style>
</head>
<body >
<div align="center"><h1>Student Data</h1></div>
<table class="table">
<thead>
<tr>
<th scope="col">Sid</th>
      <th scope="col">Name</th>
      <th scope="col">Age</th>
      <th scope="col">Mobile</th>
      <th scope="col">Address</th>
      <th scope="col">Email</th>
      <th scope="col">Course</th>
</tr>
</thead>
<tbody>
<%  ArrayList<Student1> al=(ArrayList<Student1>)request.getAttribute("studentlist");
for(Student1 s1:al){%>
	<tr>
	<td><%=s1.getSid() %></td>
	<td><%=s1.getName() %></td>
	<td><%=s1.getAge() %></td> 
	<td><%=s1.getMobile() %></td>
	<td><%=s1.getAddress() %></td>
	<td><%=s1.getEmail() %></td>
	<td><%=s1.getCourse() %></td>
	</tr>
<% }%>
</tbody>
</table>

</body>
</html>