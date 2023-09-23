<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.usermanagement.bean.User"%>
<%@page import="java.util.ArrayList"%>
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
        <br>
        <h1><center>USER MANAGEMENT PROJECT</center></h1>
        
        <div class="container">
        <hr></hr>
        <div>
        <a href="add" class="btn btn-success">ADD USER</a>
        </div>
        <br>
        <table class="table table-success table-striped">
        <thead>
        <tr>
        <th>ID</th>
         <th>NAME</th>
          <th>EMAIL</th>
           <th>CITY</th>
            <th>ACTIONS</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<User> al =(ArrayList<User>) request.getAttribute("userlist");
        for(User u: al)
        {
        %>
        <tr>
        <td><%=u.getId()%></td>
          <td><%=u.getName()%></td>
            <td><%=u.getEmail()%></td>
              <td><%=u.getCity()%></td>
                <td><a href="delete?id=<%=u.getId()%>">delete</a></td>
        
        </tr>
        <%
        }
        %>
        </tbody>
        </table>
        </div>
</body>
</html>