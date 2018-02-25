<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file='../_cabecalho.jsp' %>
		
	<div class="container">
    <h1>Lista de Contatos</h1>
    <hr>
    <div>

		<spring:url value="/usuario/cadastro" var="cadastro"/>
        <a class="btn btn-default" href="${cadastro }">Novo Contato</a>
    </div>
    <hr>

    <div class="panel-default">

        <div class="panel-heading">
            <span>${message == null ? '&nbsp;' : message}</span>
        </div>

        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>EMAIL</th>
                <th>ENDEREÇO</th>
                <th>CONTATOS</th>
                <th>AÇÃO</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pessoa" items="${pessoas }">
                <tr>
                    <td>${pessoa.id }</td>
                    <td>${pessoa.nome }&nbsp;${pessoa.sobrenome }</td>
                    <td>${pessoa.email }</td>
                 	<td>contatos</td>
                    <td>                        
                    	<spring:url value="/usuario/update/${pessoa.id }" var="update"/>
                        <a class="btn btn-info" href="${update }" >Editar</a>
                        <spring:url value="/usuario/delete/${pessoa.id }" var="delete"/>
                        <a class="btn btn-danger" href="${delete }" >Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <hr>
    <footer class="footer">
        <p>&copy; 2018 Sistema de Agenda de Contatos</p>
    </footer>
</div>


<%@ include file='../_rodape.jsp' %>