<%-- 
    Document   : produtos
    Created on : 10/04/2019, 16:15:26
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Produtos</title>
        <%@ include file="shared/head.jsp" %>
    </head>
    <body>
        <%@ include file="shared/navbar.jsp" %>


        <div class="container mt-5">
            <div class="row">
                <div class="col-md-12">
                    <form action="FrontController?action=CadastrarProdutoLoja" method="post" class="form-group">
                        <h3 class="h4 text-left">Cadastrar novos produto <button type="submit" class="btn btn-md btn-success">Cadastrar</button></h3>                         
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-borderless">
                        <thead>
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">Preço</th>
                                <th scope="col">Ação</th>
                            </tr>
                        </thead>
                        <tbody><c:forEach items="${produtos}" var="produto">
                                <tr>

                                    <td>${produto.nome}</td>
                                    <td>${produto.preco}</td>
                                    <td><a href="FrontController?action=LerProdutoLoja&id=${produto.id}" class="btn btn-sm btn-outline-secondary">Editar</a>
                                        <a href="FrontController?action=DeletarProdutoLoja&id=${produto.id}" class="btn btn-sm btn-outline-danger">Deletar</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
