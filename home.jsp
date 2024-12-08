<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	</head>
<body>
	<h5>Home page</h5>
	<form action="studenthome" method="post">
		<nav class="navbar bg-primary" data-bs-theme="dark">
			<input type="submit"  name="action" value="Add Student">
			<input type="submit"  name="action" value="Display">
			<input type="submit"  name="action" value="Delete">
			<input type="submit"  name="action" value="Update">
		</nav>
	</form>
</body>
</html>