<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>

body{
    height:100vh;
    margin:0;
    display:flex;
    justify-content:center;
    align-items:center;

    /* Library Background */
    background: linear-gradient(rgba(0,0,0,0.65), rgba(0,0,0,0.65)),
    url('https://images.unsplash.com/photo-1521587760476-6c12a4b040da?auto=format&fit=crop&w=1600&q=80');

    background-size:cover;
    background-position:center;
    font-family: 'Segoe UI', sans-serif;
}

/* Glass Card */
.login-card{
    background: rgba(255,255,255,0.12);
    backdrop-filter: blur(12px);
    padding:50px;
    border-radius:20px;
    width:350px;
    box-shadow:0 10px 35px rgba(0,0,0,0.5);
    color:white;
    animation: fadeIn 0.6s ease-in-out;
}

@keyframes fadeIn{
    from{opacity:0; transform: translateY(20px);}
    to{opacity:1; transform: translateY(0);}
}

input{
    background: rgba(255,255,255,0.2) !important;
    color:white !important;
    border:none !important;
}

input::placeholder{
    color:#ddd !important;
}

.btn-custom{
    background:#16a34a;
    border:none;
}

.btn-custom:hover{
    background:#15803d;
}

</style>

</head>

<body>

<div class="login-card text-center">

<h3 class="mb-4">
<i class="bi bi-mortarboard-fill"></i>
Student Management System
</h3>

<form action="login" method="post">

<div class="mb-3">
<input type="text" name="username"
class="form-control"
placeholder="Username" required>
</div>

<div class="mb-3">
<input type="password" name="password"
class="form-control"
placeholder="Password" required>
</div>

<button type="submit" class="btn btn-custom w-100">
Login
</button>

<div class="mt-3">
Don't have an account?
<a href="signup.jsp">Sign Up</a>
</div>


</form>

<div class="mt-3">
<small>Secure Admin Access</small>
</div>

</div>

</body>
</html>
