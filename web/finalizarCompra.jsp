<%-- 
    Document   : finalizarCompra
    Created on : 13/04/2019, 23:11:04
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
                                <h2 class="bradcaump-title">Finalizar compra</h2>
                                <nav class="bradcaump-inner">
                                    <a class="breadcrumb-item" href="FrontController?action=PrepararHomeConsumidor">Início</a>
                                    <span class="brd-separetor"><i class="zmdi zmdi-long-arrow-right"></i></span>
                                    <span class="breadcrumb-item active">Finalizar compra</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area -->

        <section class="htc__checkout bg--white section-padding--lg">
            <!-- Checkout Section Start-->
            <div class="checkout-section">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-6 col-12 mb-30">

                            <!-- Checkout Accordion Start -->
                            <div id="checkout-accordion">
                                <!-- Shipping Method -->
                                <div class="single-accordion">
                                    <a class="accordion-head collapsed" data-toggle="collapse" data-parent="#checkout-accordion" href="#shipping-method">Entrega</a>
                                    <div id="shipping-method" class="collapse">
                                        <div class="accordion-body shipping-method fix">

                                            <h5>Endereço de entrega</h5>
                                            <p><span>Endereço&nbsp;</span>${consumidor.endereco.logradouro}, ${consumidor.endereco.numero}, ${consumidor.endereco.bairro}, ${consumidor.endereco.cidade}, ${consumidor.endereco.estado}</p>
                                            <p>${consumidor.endereco.cep}</p>
                                        </div>
                                    </div>
                                </div>

                                <!-- Payment Method -->
                                <div class="single-accordion">
                                    <a class="accordion-head collapsed" data-toggle="collapse" data-parent="#checkout-accordion" href="#payment-method">Pagamento</a>
                                    <div id="payment-method" class="collapse">
                                        <div class="accordion-body payment-method fix">
                                            <ul class="payment-method-list">
                                                <li class="active">Dinheiro na entrega</li>
                                                <li class="payment-form-toggle">Cartão de crédito</li>
                                            </ul>
                                            <form action="#" class="payment-form">
                                                <div class="row">
                                                    <div class="input-box col-12 mb--20">
                                                        <c:forEach items="${cartoes}" var="cartao">
                                                            cartão: ${cartao.numero} - ${cartao.titular}
                                                            <label for="card-number">Código de segurança</label>
                                                            <input type="text" id="txtCod" class="form-control"/>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                            </div><!-- Checkout Accordion Start -->
                        </div>

                        <!-- Order Details -->
                        <div class="col-lg-6 col-12 mb-30">

                            <div class="order-details-wrapper">
                                <h2>Seu pedido</h2>
                                <div class="order-details">
                                    <ul>
                                        <li><p class="strong">Produto</p><p class="strong">total</p></li>
                                        <c:forEach items="${pedidos}" var="pedido">
                                            <li><p>${pedido.produto.nome} - R$ "${pedido.produto.getPrecoDeVenda()}"</p></li>
                                        </c:forEach>
                                        <li><p class="strong">Total</p><p class="strong">R$ ${total}</p></li>
                                        <li>
                                            <form action="FrontController?action=FinalizarCompraConsumidor" method="post">
                                                <button type="submit" class="food__btn">Finalizar Compra</button>
                                            </form>    
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- Checkout Section End-->             
        </section>   
    </body>
    <%@ include file="./shared/footer.jsp" %>
</html>
