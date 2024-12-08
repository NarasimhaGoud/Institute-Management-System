<%@page import="com.minproject.bean.Student1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="home.jsp" %>
    <!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Update file</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
<div align="center" ><h1>Update student details</h1></div>

<form action="showdata" method="post"><div align="center">

  <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Enter mobile number</label>
    <input type="number" style="width:300px;" name="txtmobile" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
    <button type="submit" style="color:green;" value="showdata">show data</button>
  </div>
 </div>
</form>
<% if(request.getAttribute("student")!=null){
    if(request.getAttribute("student").equals("Invalid mobile number")){%>
    	<div align="center"><label style="color:red;"><%=request.getAttribute("student") %></label></div>
   <% }
    else
    {
    Student1 s=(Student1)request.getAttribute("student");%>
    
    
	<form  action="updatestudent" method="post">
	
	<input type="hidden"value="<%=s.getSid()%>" name="txtsid">
 <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" style="width:300px;" name="txtname" value ="<%=s.getName()%>"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
  </div>
  
   <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Age</label>
    <input type="text" style="width:300px;" name="txtage" value ="<%=s.getAge() %>"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
  </div>
  
   <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Mobile</label>
    <input type="number" style="width:300px;" name="txtmobile" value ="<%=s.getMobile() %>"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
  </div>
  
 <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Address</label>
    <input type="text" style="width:300px;" name="txtaddress" value ="<%=s.getAddress() %>"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
  </div>
   <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="text" style="width:300px;" name="txtemail" value ="<%=s.getEmail() %>"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
  </div>
   <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Course</label>
    <input type="text" style="width:300px;" name="txtcourse" value ="<%=s.getCourse() %>"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
    <div class="mb-3" align="center">
    </div>
    <div class="mb-3" align="center"><button type="submit" style="color:green;" value="updatestudent">update data</button></div>
    <%} 
    } %>
  </form>
  <%if(request.getAttribute("message")!=null){
	  %>
	  <div align="center"><label style="color:green;"><%=request.getAttribute("message") %></label></div>
     <%} %>
  
</body>
</html>