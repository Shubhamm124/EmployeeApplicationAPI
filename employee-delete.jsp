<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Are you sure you want to delete this employee?</h1>
    <p><strong>Name:</strong> ${employee.name}</p>
    <p><strong>Position:</strong> ${employee.position}</p>
    <p><strong>Salary:</strong> ${employee.salary}</p>
    <form action="/employees/delete/${employee.id}" method="post">
        <button type="submit">Delete</button>
    </form>
    <a href="/employees">Cancel</a>
</body>
</html>