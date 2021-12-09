<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commandes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link  rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src= "https://code.jquery.com/jquery-3.5.1.js"></script>
<script src= "https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">CommandeClients</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ProduitsServlet?act=2">Produis</a>
        </li>
          <li class="nav-item">
          <a class="nav-link active" aria-current="page"  href="CommandesServlet?act=list">Commandes</a>
        </li>
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="UtilisateurServlet?action=logout"  style="  position: absolute;right: 20px ;">Logout</a>
        </li>
      </ul>
  
    </div>
  </div>
</nav>
	<div class="limiter">
		<div class="container" style="text-align: center;">
			<span style="font-size: 40px; color: white;">Commandes</span>
			<table class="table table-hover" id="example">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Date</th>
						<th scope="col">Utilisateur</th>
						<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
							<th scope="col">Delete</th>
						</c:if>
						<th scope="col">Détail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ listCmd }" var="cmd">
						<tr>
							<th scope="row">${ cmd.getIdCmd() }</th>
							<td>${ cmd.getDateCmd() }</td>
							<td>${ cmd.getIdUtil() }</td>
							<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
								<td><a href="CommandesServlet?act=delete&id=${ cmd.getIdCmd() }">
										delete </a></td>
								
							</c:if>
								<td><a href="CommandesServlet?act=detail&id=${ cmd.getIdCmd() }">
										détail </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
				<a href="CommandesServlet?act=saveC" style="color: black; font-size: 20px;"> Nouvelle Commande </a> <br/>
			</c:if>
			
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script  src="js/script.js"></script>
</body>
</html>