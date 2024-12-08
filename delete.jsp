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
<style >h6{color:red;"}
body{backgroundcolor:"lightred"}
</style>
</head>
<body>
<form action="deletestudent" method="post">
<div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Enter mobile number</label>
    <input type="number" style="width:300px;" name="txtmobile"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" ><br>
    <input type ="submit" name="action" style="color:red;value="Delete">
  <% if(request.getAttribute("delete")!=null){
	out.println("<h6>"+request.getAttribute("delete")+"<h6>");
}
%>
</div>
</form>

</body>
</html>