<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un produits</title>
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
			
			<form action="CommandesServlet?act=saveL" method="post" >
				<span style="font-size: 40px; color: black;">Nouvelle ligne de commande nº ${ sessionScope.idCmd } </span>
				
				<br><br>
				<label>Choisir un produit</label>
				<select name = "idProd" id="idProd">
					<c:forEach items="${ listProd }" var="prod">
						    <option value = "${prod.getIdProd()}" >
						          ${prod.getNomProd()}                    ${prod.getPrixProd()}
						    </option>
						    </c:forEach>
						</select>
						<br><br>
				
                
                    <label>quantité</label>
					<input  type="text" name="quantite" placeholder="quantite du produit"/>
			         		<input name="idCmd" value="${ sessionScope.idCmd }" type="hidden" />
					
				    <br><br>
					<input class="btn btn-primary" type="submit" name="save" value="Enregistrer"> <br />
			
				
				 <div style="text-align: center; margin-top: 20px;">
					<a href="CommandesServlet?act=detail&id=${sessionScope.idCmd}" style="color: black; font-size: 20px;">Annuler</a>
				</div>
				
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>