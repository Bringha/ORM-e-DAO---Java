<%-- 
    Document   : cadastrar
    Created on : 17/11/2021, 23:42:32
    Author     : fabio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Curso" %>
<%@page import="model.CursoDAO" %>
<%
    String cod = request.getParameter("cod");
    CursoDAO dao = new CursoDAO();
    Curso obj = dao.buscar("codigo=" + cod);
%>
<c:set var="curso" value="<%=obj%>" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Curso</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Formulário de Atualizaçao de um Curso</h1>

            <form action="exec" method="post">            
                <div class="mb-3">
                    <label for="InputNom" class="form-label">Código</label>
                    <input class="form-control" type="number" name="cod" readonly="true" value="${curso.codigo}">
                </div>
                
                <div class="mb-3">
                    <label for="InputNom" class="form-label">Nome</label>
                    <input type="text" name="nom" class="form-control" value="${curso.nome}">
                </div>

                <div class="mb-3">
                    <label for="InputDes" class="form-label">Descricao</label>
                    <textarea name="des" class="form-control">${curso.descricao}</textarea>
                </div>
                
                <div class="mb-3">
                    <label for="InputVal" class="form-label">Valor</label>
                    <input type="number" name="val" class="form-control" value="${curso.valor}">
                </div>
                
                <input type="hidden" name="tip" value="update">
                <button class="btn btn-success">Atualizar</button>                
            </form>
        </div>
    </body>
</html>
