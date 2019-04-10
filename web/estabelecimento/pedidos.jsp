<%-- 
    Document   : pedidos
    Created on : 10/04/2019, 12:11:36
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Pedidos</title>
        <%@ include file="shared/head.jsp" %>
    </head>
    <body>
        <%@ include file="shared/navbar.jsp" %>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6">
                    <h3 class="h4 text-center">Pedidos pendentes</h3>
                    <table class="table table-borderless">
                        <thead>
                            <tr>
                                <th scope="col">Cliente</th>
                                <th scope="col">Valor</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <c:forEach items="${carrinhos}" var="carrinho">
                                <td>${carrinho.consumidor.nome}</td>
                                <td>${carrinho.valor}</td>
                                <td>${carrinho.estado}</td>
                                <td><a href="#" class="btn btn-sm btn-outline-success">Visualizar pedido</a></td>
                            </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h3 class="h4 text-center">Pedidos em processamento</h3>
                    <table class="table table-borderless">
                        <thead>
                            <tr>
                                <th scope="col">Cliente</th>
                                <th scope="col">Valor</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <c:forEach items="${carrinhos}" var="carrinho">
                                <td>${carrinho.consumidor.nome}</td>
                                <td>${carrinho.valor}</td>
                                <td>${carrinho.estado}</td>
                                <td><a href="#" class="btn btn-sm btn-outline-success">Visualizar pedido</a></td>
                            </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
