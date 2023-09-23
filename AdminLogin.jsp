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
<form action="validate" method="post">

<div class="container" align="center" style="padding-top: 100px">

<div class="card" style="width: 25rem;">

<h1>Login Page</h1>

<div class="mb-3">
  <label for="name" class="form-label">User Name</label>
  <input type="text" class="form-control" id="name" name="name"  style="width: 300px">
</div>

<div class="mb-3">
  <label for="password" class="form-label">Password</label>
  <input type="password" class="form-control" id="password" name="password" style="width: 300px">
</div>

  <div class="mb-3">
    <input class="btn btn-success" type="submit" value="Login" style="width: 200px">
  </div>
  
  </div>
  </div>
  
</form>
</body>
</html>