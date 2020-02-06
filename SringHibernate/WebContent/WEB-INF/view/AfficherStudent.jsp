<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%-- <link rel=stylesheet href="${pageContext.request.contextPath}/ressources/css/Style.css"/>--%>

</head>
<body>
<h1>Etudiant présent dans la base de données</h1>

<style>
body{
background-color:rgb(238,238,238);
}
h1{
	text-align:  center;
}
</style>



<table class="table table-sm table-dark">
	<td>Nom</td>
     <td>Prenom</td>
      <td>Email</td>
       <td>Suprimer un étudiants</td>
       <td>Modifier un étudiants</td>
<c:forEach var="i"  items="${Liststu}" >
<tr>

    <td> <c:out value="${i.nom}"/> </td>
     <td> <c:out value="${i.prenom}"/> </td>
      <td> <c:out value="${i.email}"/> </td>
      <td><form action="delete" method="get" class="form-example">
      <input type="hidden" name="id" id="id" value="${i.id}">
     <input type="submit" value=Suprimer  class="btn btn-danger">
     </form></td>
      <td><form action="modifierbdd" method="get" class="form-example">
      <input type="hidden" name="bModifier" id="bModifier" value="i">
     <input type="submit" value=Modifier  class="btn btn-info">
     </form></td>
     
     
     <td>
     
  
<form action="aoutBdd" modelAttribute ="student">
 <td> 
<input type ="text"  placeholder="${i.nom}"/>
</td>
 <td> 
<input type ="text"  placeholder="${i.prenom}"/>
</td>
 <td> 
<input type ="text"  placeholder="${i.email}"/>
</td>
</form>
   
        </tr>
 </c:forEach>
 </table>
 
<a class="btn btn-primary" href="http://localhost:8080/SringHibernate/FormStudent">Ajouter un étudiant</a>
<a class="btn btn-primary" href="http://localhost:8080/SringHibernate/">Accueil</a>



</body>
</html>