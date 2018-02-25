<%@ include file='../_cabecalho.jsp' %>
		
	<div class="container">
    
    	<h1>Cadastro de Pessoas</h1>
    	<hr>
	    <div>
	
			<spring:url value="/home" var="home"/>
			<a class="btn btn-default" href="${home }">Home</a>
	    </div>
	    <hr>
    
    <div>
    	<spring:url value="${pessoa.id == null ? '/pessoa/save' : '/pessoa/update'}" var="save"/>    		
        <form:form modelAttribute="pessoa" action="${save }" method="post">
        
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
                <label for="endereco">Endereço: </label>
                <form:input path="endereco"  class="form-control"/>    
                <form:errors path="endereco" cssClass="label label-danger"/>          
            </div>
                        
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Confirmar</button>
                <button type="reset" class="btn btn-danger">Cancelar</button>
            </div>
        </form:form>
    </div>
    <hr>
    <footer class="footer">
        <p>&copy; 2018 Sistema de Agenda de Contatos</p> 
    </footer>
</div>


<%@ include file='../_rodape.jsp' %>