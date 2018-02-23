<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <spring:url value="/static/css/bootstrap.css" var="css" />
	<link rel="stylesheet" type="text/css" href="${css}">
    
    <spring:url value="/static/css/bootstrap.min.css" var="bootstrapMin" />
    <link rel="stylesheet" type="text/css" href="${bootstrapMin}">
    
    <spring:url value="/static/js/bootstrap.js" var="bootstrapJs"/>
    <script type="text/javascript" src="${bootstrapJs}"></script>
    <title>Cadastro de Usuário</title>
</head>
<body>
<div class="container">
    <h1>Cadastro de Usuários</h1>
    <hr>
    <div>

		<spring:url value="/usuario/todos" var="home"/>
		<a class="btn btn-default" href="${home }">Home</a>
    </div>
    <hr>
    <div>
    	<spring:url value="${usuario.id == null ? '/usuario/save' : '/usuario/update'}" var="save"/>
        <form:form modelAttribute="usuario" action="${save }" method="post">
        	<form:hidden path="id"/>
            <div class="form-group">
                <label for="nome">Nome: </label>
                <form:input path="nome" class="form-control"/>   
                <form:errors path="nome" cssClass="label label-danger"/>             
            </div>
            <div class="form-group">
                <label for="sobrenome">Sobrenome: </label>
                <form:input path="sobrenome"  class="form-control"/>    
                <form:errors path="sobrenome" cssClass="label label-danger"/>          
            </div>
            <div class="form-group">
                <label for="sexo">Sexo: </label>
                <form:select path="sexo" class="form-control">
                	<form:options items="${sexos }" itemLabel="desc"/>
                </form:select>
            </div>          
            <div class="form-group">
                <label for="dtNascimento">Data Nascimento: </label>
                <form:input path="dtNascimento"  class="form-control" type="date"/>  
                <form:errors path="dtNascimento" cssClass="label label-danger"/>    
            </div> 
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Confirmar</button>
            </div>
        </form:form>
    </div>
    <hr>
    <footer class="footer">
        <p>&copy; 2017 DevMedia</p> 
    </footer>
</div>
</body>
</html>