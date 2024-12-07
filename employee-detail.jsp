<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Details</h1>
    <p><strong>ID:</strong> ${employee.id}</p>
    <p><strong>Name:</strong> ${employee.name}</p>
    <p><strong>Position:</strong> ${employee.position}</p>
    <p><strong>Salary:</strong> ${employee.salary}</p>
    <a href="/employees">Back to Employee List</a>
</body>
</html>