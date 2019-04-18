<%-- 
    Document   : meusPedidos
    Created on : 13/04/2019, 22:31:03
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

    <head>
        <title>FoodQueen - Meus Pedidos</title>
        <%@ include file="./shared/head.jsp" %>
    </head>
    <body>
        <div class="wrapper" id="wrapper">
            <%@ include file="./shared/navbar.jsp" %>
        </div>

        <!-- Start Bradcaump area -->
        <div class="ht__bradcaump__area bg-image--18">
            <div class="ht__bradcaump__wrap d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">Meus Pedidos</h2>
                                <nav class="bradcaump-inner">
                                    <a class="breadcrumb-item" href="FrontController?action=PrepararHomeConsumidor">Início</a>
                                    <span class="brd-separetor"><i class="zmdi zmdi-long-arrow-right"></i></span>
                                    <span class="breadcrumb-item active">Meus Pedidos</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area --> 

        <section class="blog__list__view section-padding--lg menudetails-right-sidebar bg--white">
            <div class="container">
                <div class="row">
                    <div class="col-sm-0 col-md-1 col-lg-2"></div>
                    <div class="col-sm-12 col-md-10 col-lg-8">
                        <c:forEach items="${carrinhos}" var="carrinho">
                            <div class="single-accordion">
                                <a class="accordion-head collapsed" data-toggle="collapse" data-parent="#checkout-accordion" href="#payment-method${carrinho.id}">Pedido da loja ${carrinho.loja.nome}</a>
                                <div id="payment-method${carrinho.id}" class="collapse">
                                    <div class="accordion-body payment-method fix">
                                        <div class="row">
                                            <div class="input-box col-12 mb--20">
                                                <label> Loja </label>
                                                <p>${carrinho.loja.nome}</p>
                                            </div>
                                            <div class="input-box col-12 mb--20">
                                                <label>Valor total </label>
                                                <p>${carrinho.valor}</p>
                                            </div>
                                            <div class="input-box col-12">
                                                <div class="input-box col-12 mb--20">
                                                    <label>Estado do pedido</label>
                                                    <p>${carrinho.estado.getEstadoMsg()}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-sm-0 col-md-1 col-lg-2"></div>
                </div>
            </div>
        </section>
    </body>
    <%@ include file="./shared/footer.jsp" %>
</html>
