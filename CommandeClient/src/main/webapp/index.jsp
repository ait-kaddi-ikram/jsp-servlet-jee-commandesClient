<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="Container" style="text-align: center;">

<div class="row ">
<div class="col-4">
  </div>  
  <div class="col-4">
  <br><br>
<h1>Authentification</h1>
 <br><br>
<form action="UtilisateurServlet?action=auth" method="post">
<div class="row ">
<div class="col-6">
<label> Email </label>
 </div>
<div class="col-6">
 <input type="text"  name="emailUtil"> <br/>

 </div>
 <br>
 <div class="row ">
<div class="col-6">
<label> Password </label>
 </div>
 <div class="col-6">
 <input type="password"  name="passwordUtil"> <br/>

 </div>
 <br><br>
 <div class="row ">
 <div class="col-4">
  </div>
   <div class="col-4">
 <input type="submit" class="btn btn-primary" name="ok"  value="Se Connecter"> <br/>
  </div>
   <div class="col-4">
  </div>
</form>
<br><br>
<a  href="createUser.jsp">Creér un compte</a>
</div>
<div class="col-4">
  </div>
 </div>
 
  </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>