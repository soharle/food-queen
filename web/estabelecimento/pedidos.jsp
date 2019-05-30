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
                <c:if test="${msg != null}">
                    <div class="container alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Atenção</strong> ${msg}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <div class="accordion" id="accordionExample">
                    <c:forEach items="${pedidos}" var="pedido">
                        <div class="card text-center">
                            <div class="card-header" id="headingOne">
                                <h2 class="mb-0">
                                    <button class="btn btn-dark btn-lg btn-block" type="button" data-toggle="collapse"
                                        data-target="#collapse${pedido.id}" aria-expanded="true"
                                        aria-controls="collapse${pedido.id}">
                                        <p>Carrinho do cliente ${pedido.consumidor.nome} no valor de R$ ${pedido.valor}
                                        </p>
                                    </button>
                                </h2>
                            </div>

                            <div id="collapse${pedido.id}" class="collapse show" aria-labelledby="headingOne"
                                data-parent="#accordionExample">
                                <div class="card-body">
                                    <c:forEach items="${pedidos}" var="pedido">
                                        <c:if test="${carrinho.id == pedido.carrinho.id}">
                                            <c:forEach items="${produtos}" var="produto">
                                                <c:if test="${pedido.produto.id == produto.id}">
                                                    <div class="card m-4">
                                                        <div class="row no-gutters">
                                                            <div class="col-md-4">
                                                                <img src="${produto.imagem}"
                                                                    class="card-img img-responsive"
                                                                    style="max-height: 150px;max-width: 202px;"
                                                                    alt="...">
                                                            </div>
                                                            <div class="col-md-8">
                                                                <div class="card-body">
                                                                    <h5 class="card-title">${produto.nome}</h5>
                                                                    <p class="card-text">${produto.descricao}</p>
                                                                    <p class="card-text"><small class="text-muted">R$
                                                                            ${produto.preco}</small></p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>

                                    <p>Estado do pedido: ${pedido.estado.getEstadoMsg()}</p>
                                    <h4 class="h4">
                                        Alterar estado
                                    </h4>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <a href="FrontController?action=MudarEstadoLoja&id=${pedido.id}&estado=aprovar"
                                            type="button" class="btn btn-secondary">Aprovar</a>
                                        <a href="FrontController?action=MudarEstadoLoja&id=${pedido.id}&estado=naoAprovar"
                                            type="button" class="btn btn-secondary">Não Aprovar</a>
                                        <a href="FrontController?action=MudarEstadoLoja&id=${pedido.id}&estado=sairParaEntrega"
                                            type="button" class="btn btn-secondary">Saiu para entrega</a>
                                        <a href="FrontController?action=MudarEstadoLoja&id=${pedido.id}&estado=entregar"
                                            type="button" class="btn btn-secondary">Entregue</a>
                                    </div>
                                    <hr>
                                    <div>
                                        <a href="FrontController?action=MementoEstadoLoja&id=${pedido.id}&memento=retroceder"
                                            type="button" class="btn btn-secondary">
                                            <-</a> <!-- <a
                                                href="FrontController?action=MementoEstadoLoja&id=${pedido.id}&memento=salvar"
                                                type="button" class="btn btn-secondary">Salvar
                                        </a> -->
                                        <a href="FrontController?action=MementoEstadoLoja&id=${pedido.id}&memento=avancar"
                                            type="button" class="btn btn-secondary">-></a>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>

</html>