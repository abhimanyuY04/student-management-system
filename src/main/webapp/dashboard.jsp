<%
if(session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>

body{
    margin:0;
    font-family: Arial, sans-serif;
}

/* Sidebar */
.sidebar{
    height:100vh;
    background:#0f172a;
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
    transition:0.3s;
}

.sidebar a:hover{
    background:#1e293b;
}

/* Main Area */
.main-area{
    min-height:100vh;
    background: linear-gradient(135deg, #3b82f6, #1e3a8a);
    color:white;
    padding:50px;
}

/* Card Animation */
.dashboard-card{
    border-radius:15px;
    padding:30px;
    text-align:center;
    transition:0.4s;
    box-shadow:0 4px 20px rgba(0,0,0,0.3);
}

.dashboard-card:hover{
    transform: translateY(-8px);
}

/* Glass effect */
.glass{
    background: rgba(255,255,255,0.1);
    backdrop-filter: blur(8px);
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

<!-- Main Content -->
<div class="col-md-10 main-area">

<h2 class="mb-5">Welcome, <%= session.getAttribute("user") %></h2>

<div class="row">

<!-- Total Students Card -->
<div class="col-md-4">
<div class="dashboard-card glass">
<i class="bi bi-people-fill" style="font-size:50px;"></i>
<h4 class="mt-3">Total Students</h4>
<h1><%= request.getAttribute("totalStudents") %></h1>
</div>
</div>

<!-- Quick Action Card -->
<div class="col-md-4">
<div class="dashboard-card glass">
<i class="bi bi-person-plus-fill" style="font-size:50px;"></i>
<h4 class="mt-3">Add New Student</h4>
<a href="add-student.html" class="btn btn-light mt-2">
Go to Add Page
</a>
</div>
</div>

</div>

</div>

</div>
</div>

</body>
</html>
