<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.sms.model.Student" %>
    <% Student s = (Student)request.getAttribute("student"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body class="bg-light">
<div class="container mt-5">
<div class="card shadow p-4">

<h3 class="text-center mb-4">Update Student</h3>

<form action="updateStudent" method="post">
<input type="hidden" name="id" value="<%=s.getId() %>">

<div class="mb-3">
<label>Name</label>
<input type="text" name="name" class="form-control" value="<%=s.getName() %>" required>
</div>

<div class="mb-3">
<label>Age</label>
<input type="number" name="age" class="form-control" value="<%=s.getAge() %>" required>
</div>

<button type="submit" class="btn btn-success w-100">Update Student</button>
</form>
</div>
</div>

</body>
</html>