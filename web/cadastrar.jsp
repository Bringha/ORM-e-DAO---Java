<%-- 
    Document   : cadastrar
    Created on : 17/11/2021, 23:42:32
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Curso</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Formulário de Cadastro de um Curso</h1>

            <form action="exec" method="post">
                <div class="mb-3">
                    <label for="InputNom" class="form-label">Nome</label>
                    <input type="text" name="nom" class="form-control">
                </div>

                <div class="mb-3">
                    <label for="InputDes" class="form-label">Descricao</label>
                    <textarea name="des" class="form-control"></textarea>
                </div>
                
                <div class="mb-3">
                    <label for="InputVal" class="form-label">Valor</label>
                    <input type="number" name="val" class="form-control">
                </div>
                
                <input type="hidden" name="tip" value="insert">
                <button class="btn btn-success">Cadastrar</button>                
            </form>
        </div>
    </body>
</html>
