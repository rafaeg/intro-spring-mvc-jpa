<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
<head>
	<spring:url value="/static/css/bootstrap.css" var="css" />
	<link rel="stylesheet" type="text/css" href="${css}">
    
    <spring:url value="/static/css/bootstrap.min.css" var="bootstrapMin" />
    <link rel="stylesheet" type="text/css" href="${bootstrapMin}">
    
    <spring:url value="/static/js/bootstrap.js" var="bootstrapJs"/>
    <script type="text/javascript" src="${bootstrapJs}"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Página Principal</title>

</head>

<body>
	
	<!-- Menu principal --> 
	<nav class="navbar navbar-default">
   		<div class="container">
      		<!--Rio de Janeiro-->
      
		      <div class="navbar-header"></div><a href="#" class="navbar-brand">Sistema Agenda</a>
		            <button class="navbar-toggle collapsed" 
		                    data-toggle="collapse" 
		                    data-target="#collapsemenu">
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		            </button>
		       <div class="collapse navbar-collapse" id="collapsemenu">
		       
		        <ul class="nav navbar-nav">
		            <li><a href="#"><span class="glyphicon glyphicon-signal"></span> Dashboard</a></li>
		               
		                <li>
		                	<a href="#" 
		                	   class="dropdown-toggle" 
		                       data-toggle="dropdown">Contatos<span class="caret"></span>
		                   </a>
	                       <ul class="dropdown-menu">
	                        <li><a href="#">Cadastrar</a></li>
	                        <li><a href="#">Listar</a></li>
	                        <li class="divider"></li>
	                        <li><a href="#">Menu 2</a></li>		                  
	                       </ul>
	                       		                    
		                </li>
		      	
		      			<li>
		      				<a href="#" 
		      				   class="dropdown-toggle" 
		                       data-toggle="dropdown">Usuário<span class="caret"></span>
		                    </a>		                    
		                    <ul class="dropdown-menu">
		                        <li><a href="#">Cadastrar</a></li>
		                        <li><a href="#">Listar</a></li>
		                        <li class="divider"></li>
		                        <li><a href="#">Menu 2</a></li>		                  
		                    </ul>		                    
		                </li>
		                
		       </ul>
		       
		      </div>
		    
		    </div><!-- fim container -->  
		                 
		</nav>
<!-- fim menu principal -->





	
<spring:url value="/static/js/jquery-1.12.4.js" var="jquery" />	
<script src="${jquery }"></script>

<spring:url value="/static/js/bootstrap.js" var="bootstrapJs" />
<script src="${bootstrapJs }"></script>

<spring:url value = "/static/js/script.js" var="script" />
<script src="${script }"></script>

</body>
</html>    