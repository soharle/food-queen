<%-- 
    Document   : index
    Created on : 09/04/2019, 13:31:08
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Admin - Home</title>
        <%@ include file="shared/head.jsp" %>
    </head>
    <body>
        <%@ include file="shared/navbar.jsp" %>
        <div class="container mt-5">
            <div class="row">
                <div class="col-sm-12 col-md-6 col-lg-4 my-3">
                    <div class="card" style="width: 18rem;">
                        <img src="./assets/images/estabelecimento/att-dados.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Dados do estabelecimento</h5>
                            <p class="card-text">Nesta opção você pode atualizar os dados do seu estabelecimento</p>
                            <div class="text-center">
                                <a href="FrontController?action=PrepararEditarLoja" class="btn btn-dark btn-block">Editar dados</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12 col-md-6 col-lg-4 my-3">
                    <div class="card" style="width: 18rem;">
                        <img src="./assets/images/estabelecimento/cad-produtos.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Produtos</h5>
                            <p class="card-text">Aqui você pode cadastrar e editar produtos para o seu restaurante!</p>
                            <div class="text-center">
                                <a href="FrontController?action=PrepararProdutosLoja" class="btn btn-dark btn-block">Avançar</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 col-lg-4 my-3">
                    <div class="card" style="width: 18rem;">
                        <img src="./assets/images/estabelecimento/orders.jpg" style="max-height: 190px; " class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Pedidos</h5>
                            <p class="card-text">Veja todos os pedidos do seu estabelecimento</p>
                            <div class="text-center">
                                <a href="FrontController?action=PrepararPedidosLoja" class="btn btn-dark btn-block">Avançar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
