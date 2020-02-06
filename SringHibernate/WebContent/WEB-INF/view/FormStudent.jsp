<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un étudiant</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>


<h1>Ajouter un étudiant</h1>
 
   


<form:form action="ajoutBdd" modelAttribute ="student">
 <div class="form-group">
    <label >Nom</label>
<form:input path="nom" type ="text"  class="form-control"  placeholder="Nom"/>
<form:errors path="nom"/>
</div>
<br>
 <div class="form-group">
    <label >Prenom</label>
<form:input path="prenom" type ="text"  class="form-control"  placeholder="Prenom"/>
<form:errors path="prenom"/>
</div>
<br>
<div class="form-group">
    <label >Email</label>
<form:input path="email" type ="text"  class="form-control"  placeholder="nom@exemple.com"/>
<form:errors path="email"/>
</div>
<input type="submit" name="submit" value=Valider />
</form:form>
<br>

<a href="http://localhost:8080/SringHibernate/">Accueil</a>
</body>
</html>