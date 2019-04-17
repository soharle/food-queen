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
                <div class="col-md-12">
                    <h3 class="h4 text-center">Pedidos pendentes</h3>

                    <div class="accordion" id="accordionExample">
                        <c:forEach items="${carrinhos}" var="carrinho">
                            <div class="card">
                                <div class="card-header" id="headingOne">
                                    <h2 class="mb-0">
                                        <button class="btn btn-dark btn-lg btn-block" type="button" data-toggle="collapse" data-target="#collapse${carrinho.id}" aria-expanded="true" aria-controls="collapse${carrinho.id}">
                                            <p>Carrinho do cliente ${carrinho.consumidor.nome} no valor de R$ ${carrinho.valor}</p>
                                        </button>
                                    </h2>
                                </div>

                                <div id="collapse${carrinho.id}" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <p>Estado do pedido: ${carrinho.estado.getEstadoMsg()}</p>
                                        <h4 class="h4">
                                            Alterar estado
                                        </h4>
                                        <div class="btn-group" role="group" aria-label="Basic example">
                                            <button type="button" class="btn btn-secondary">Estado 1</button>
                                            <button type="button" class="btn btn-secondary">Estado 2</button>                                            
                                            <button type="button" class="btn btn-secondary">Estado 3</button>
                                            <button type="button" class="btn btn-secondary">Estado 4</button>
                                            <button type="button" class="btn btn-secondary">Estado 5</button>
                                            <button type="button" class="btn btn-secondary">Estado 6</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
