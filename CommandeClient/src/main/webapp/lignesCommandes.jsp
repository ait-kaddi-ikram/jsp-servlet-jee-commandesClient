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
          <a class="nav-link active" aria-current="page" href="UtilisateurServlet?action=logout"  style="  position: absolute;right: 20px ;" >Logout</a>
        </li>
      </ul>
  
    </div>
  </div>
</nav>
<div class="limiter">
		<div class="container" style="text-align: center;">
			<span class="login100-form-title" style="font-size: 40px; color: white;">Lignes de la commande nº ${ sessionScope.idCmd }</span>
			<table class="table table-hover" >
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Quantité</th>
						<th scope="col">Id Commande</th>
						<th scope="col">Id Produit</th>
						<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
							<th scope="col">Delete</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ listLigCmd }" var="lcmd">
						<tr>
							<th scope="row">${ lcmd.getIdLigneCmd() }</th>
							<td>${ lcmd.getQuantite() }</td>
							<td>${ lcmd.getIdCmd() }</td>
							<td>${ lcmd.getIdProd() }</td>
							<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
								<td><a href="CommandesServlet?act=deleteL&id=${ lcmd.getIdLigneCmd() }"> delete
								</a></td>
								
							</c:if>
						
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<c:if test="${sessionScope.user.getTypeUtil() != 1 }">
					<a href="CommandesServlet?act=ajouteL" style="color: black; font-size: 20px;"> Nouvelle Ligne Commande  </a> <br/>
				</c:if>
				
				<div style="text-align: center; margin-top: 20px;">
					<a href="CommandesServlet?act=list" style="color: black; font-size: 20px;">Retour</a>
				</div>
			</div>
		
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>