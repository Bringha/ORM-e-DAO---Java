<%-- 
    Document   : index
    Created on : 17/11/2021, 20:30:59
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean class="model.CursoDAO" id="lista" />

<%--
<%@page import="java.util.List" %>
<%@page import="model.Curso" %>
<%@page import="model.CursoDAO" %>
    CursoDAO dao = new CursoDAO();
    List<Curso> lst = dao.listar();

<c:set var="lista" value="<%=lst%>" />
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Mapeamento Objeto Relacional - ORM</h1>
            <h1>Classes de Manipulaçao de Dados - DAO</h1>
            <hr>

            <a href="cadastrar.jsp" class="btn btn-primary"> Cadastrar um novo Curso </a>
            <br /><br />

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Nome do Curso</th>
                        <th scope="col">Valor do Curso</th>
                        <th scope="col">Açoes</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista.cursos}" var="objCurso">
                        <tr>
                            <td>
                                <strong>${objCurso.nome}</strong>
                            </td>
                            <td>R$ ${objCurso.valor}</td>
                            <td><a href="atualizar.jsp?cod=${objCurso.codigo}" class="btn btn-warning">Atualizar</a></td>
                            <td><a href="exec?tip=delete&cod=${objCurso.codigo}" class="btn btn-danger">Excluir</a></td>             
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


            <%
                //obter uma lista dos cursos do banco de dados

                //criar um objeto cursoDAO
                //obter a lista de cursos => dao.listar();
                //foreach()
                //para gravar um novo curso no banco de dados
                //cria um objeto curso
                //ajustar valores => obj.setNome(), obj.setValor()
                //depois, cria um objeto cursoDAO
                //ai sim, usar o método para gravar => dao.inserir(obj)
            %>
        </div>


    </body>
</html>
