<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${employee == null ? 'Create New Employee' : 'Edit Employee'}</h1>
    <form action="${employee == null ? '/employees' : '/employees/' + employee.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required><br>
        
        <label for="position">Position:</label>
        <input type="text" id="position" name="position" value="${employee.position}" required><br>
        
        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" value="${employee.salary}" required><br>
        
        <button type="submit">${employee == null ? 'Create' : 'Update'} Employee</button>
    </form>
    <a href="/employees">Cancel</a>
</body>
</html>