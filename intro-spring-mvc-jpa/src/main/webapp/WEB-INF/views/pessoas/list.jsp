<%@ include file='../_cabecalho.jsp' %>

	<div class="container">
    <h1>Lista de Pessoas</h1>
    <hr>
    <div>

		<spring:url value="/pessoa/cadastro" var="add"/>
        <a class="btn btn-default" href="${add }">Nova Pessoa</a>
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
                 	<td>${pessoa.endereco }</td>
                 	<td>Contatos</td>
                    <td>                        
                    	<spring:url value="/pessoa/preUpdate/${pessoa.id }" var="update"/>
                        <a class="btn btn-info" href="${update }" >Editar</a>
                        <spring:url value="/pessoa/delete/${pessoa.id }" var="delete"/>
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