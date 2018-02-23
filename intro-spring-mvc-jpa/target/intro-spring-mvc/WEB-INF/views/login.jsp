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
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="panel-heading">
            <span>${message == null ? '&nbsp;' : message}</span>
        </div>
        <div class="row">
            <div class="cols-lg-7">
                <h3 class="page-header">Login de Acesso - Sistema Agenda de Contatos</h3>
                <br/>
                <spring:url value="/loginForm" var="acesso" />
                <form:form modelAttribute="usuario" action="${acesso}" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-8">
                            <form:input  path="email" class="form-control" id="inputEmail3" />             
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputSenha3" class="col-sm-2 control-label">Senha</label>
                        <div class="col-sm-8">             
                            <form:input path="senha" class="form-control" type= "password" id="inputSenha3"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Lembre-me
                                </label>
                                <label>
                                    <a href="#" data-toggle="tooltip" data-placement="top" title="Não está cadastrado no sistema, então faça agora">Cadastre-se</a>
                                </label>       
                                
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                        	
                            <button type="submit" class="btn btn-info">Logar</button>
                        </div>
                    </div>
                </form:form>
            </div>       
        </div>
    </div>
	
</body>
</html>