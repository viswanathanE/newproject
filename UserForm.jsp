<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <label>UserManagement</label>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="list">Users</a>
        </li>
        </ul>
        </div>
        </div>
        </nav>
        
        
<form action="insert" method="post">

<div class="container" align="center" style="padding-top: 100px">

<div class="card" style="width: 25rem;">

<h1>ADD USER</h1>

<div class="mb-3">
  <label for="name" class="form-label">User Name</label>
  <input type="text" class="form-control" id="name" name="name"  style="width: 300px">
</div>

<div class="mb-3">
  <label for="email" class="form-label">Email</label>
  <input type="email" class="form-control" id="email" name="email"  style="width: 300px">
</div>

<div class="mb-3">
  <label for="city" class="form-label">City</label>
  <input type="text" class="form-control" id="city" name="city"  style="width: 300px">
</div>

  <div class="mb-3">
    <input class="btn btn-success" type="submit" value="Login" style="width: 200px">
  </div>
  
  </div>
  </div>
  
</form>
</body>
</html>