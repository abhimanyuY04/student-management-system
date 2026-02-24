<%
if(session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

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

/* Glass Effect Card */
.card{
    background: rgba(255,255,255,0.12);
    backdrop-filter: blur(12px);
    padding:50px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 10px 35px rgba(0,0,0,0.5);
    color:white;
    animation: fadeIn 0.6s ease-in-out;
}

@keyframes fadeIn{
    from{opacity:0; transform: translateY(20px);}
    to{opacity:1; transform: translateY(0);}
}

</style>

</head>

<body>

<div class="card">

<h2 class="mb-4 text-success">
 <%= request.getAttribute("msg") %>
</h2>

<p class="mb-4">Your data has been successfully updated in the system.</p>

<a href="viewStudents" class="btn btn-success mt-2 px-4">
View Students
</a>

<a href="dashboard" class="btn btn-light mt-2 px-4">
Back to Dashboard
</a>

</div>

</body>
</html>
