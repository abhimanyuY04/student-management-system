<%@ page import="java.util.*, com.sms.model.Student" %>

<%
if(session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>

body{
    margin:0;
}

/* Sidebar */
.sidebar{
    height:100vh;
    background:#111827;
    color:white;
}

.sidebar h5{
    padding:20px 10px;
}

.sidebar a{
    color:white;
    display:block;
    padding:12px 20px;
    text-decoration:none;
}

.sidebar a:hover{
    background:#1f2937;
}

/* Background */
.main-area{
    min-height:100vh;
    background: linear-gradient(rgba(0,0,0,0.7), rgba(0,0,0,0.7)),
    url('https://images.unsplash.com/photo-1523240795612-9a054b0db644?auto=format&fit=crop&w=1500&q=80');
    background-size:cover;
    background-position:center;
    padding:40px;
    color:white;
}

/* Glass table */
.glass-table{
    background: rgba(255,255,255,0.1);
    backdrop-filter: blur(10px);
    border-radius:15px;
    padding:20px;
}

table{
    color:white;
}

</style>

</head>

<body>

<div class="container-fluid">
<div class="row">

<!-- Sidebar -->
<div class="col-md-2 sidebar">

<h5 class="text-center fw-bold">
<i class="bi bi-mortarboard-fill"></i>
Student Management System
</h5>
<hr>

<a href="dashboard">
<i class="bi bi-speedometer2"></i> Dashboard
</a>

<a href="viewStudents">
<i class="bi bi-people-fill"></i> Students
</a>

<a href="logout">
<i class="bi bi-box-arrow-right"></i> Logout
</a>

</div>

<!-- Main Area -->
<div class="col-md-10 main-area">

<h2 class="mb-4">Student List</h2>

<!-- Search -->
<form action="searchStudent" method="get" class="mb-4">
<div class="row">

<div class="col-md-4">
<input type="text" name="name"
class="form-control"
placeholder="Search by name">
</div>

<div class="col-md-2">
<button type="submit" class="btn btn-primary">
<i class="bi bi-search"></i> Search
</button>
</div>

<div class="col-md-2">
<a href="viewStudents" class="btn btn-secondary">
Reset
</a>
</div>

</div>
</form>

<div class="glass-table">

<table class="table table-hover">

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>Action</th>
</tr>
</thead>

<tbody>

<%
List<Student> list = (List<Student>)request.getAttribute("students");

if(list != null && !list.isEmpty()){
for(Student s : list){
%>

<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getAge() %></td>

<td>
<a href="editStudent?id=<%= s.getId() %>"
class="btn btn-warning btn-sm">
Edit
</a>

<a href="deleteStudent?id=<%= s.getId() %>"
class="btn btn-danger btn-sm"
onclick="return confirm('Are you sure?')">
Delete
</a>
</td>

</tr>

<%
}
}else{
%>

<tr>
<td colspan="4" class="text-center text-warning">
No Students Found
</td>
</tr>

<%
}
%>

</tbody>

</table>

</div>

<div class="mt-4">
<a href="add-student.html" class="btn btn-success">
<i class="bi bi-person-plus-fill"></i> Add Student
</a>
</div>

</div>

</div>
</div>

</body>
</html>
