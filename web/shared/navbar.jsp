<%-- 
    Document   : navbar
    Created on : 04/04/2019, 09:25:53
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<!-- Start Header Area -->
<header class="htc__header bg--white">
    <!-- Start Mainmenu Area -->
    <div id="sticky-header-with-topbar" class="mainmenu__wrap sticky__header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2 col-sm-4 col-md-6 order-1 order-lg-1">
                    <div class="logo">
                        <a href="FrontController?action=PrepararHomeConsumidor">
                            <img src="./assets/images/foodqueen.png" alt="logo images" style="height: 48px;">
                            <span class="brand"> FoodQueen</span>
                        </a>
                    </div>
                </div>
                <div class="col-lg-9 col-sm-4 col-md-2 order-3 order-lg-2">
                    <div class="main__menu__wrap">
                        <nav class="main__menu__nav d-none d-lg-block">
                            <ul class="mainmenu">
                                <li class="drop"><a href="FrontController?action=PrepararListaLojaConsumidor">Lojas</a></li>
                                <li class="drop"><a href="#">Dados pessoais</a>
                                    <ul class="dropdown__menu">
                                        <li><a href="FrontController?action=PrepararEditarDadosConsumidor">Editar dados</a></li>
                                        <li><a href="FrontController?action=PrepararEditarEnderecoConsumidor">Editar endereço</a></li>
                                        <li><a href="FrontController?action=PrepararManterCartaoConsumidor">Cartões cadastrados</a></li>
                                    </ul>
                                </li>
                                <li class="drop"><a href="FrontController?action=PrepararPedidosConsumidor">Meus Pedidos</a></li>
                            </ul>
                        </nav>

                    </div>
                </div>
                <div class="col-lg-1 col-sm-4 col-md-4 order-2 order-lg-3">
                    <div class="header__right d-flex justify-content-end">
                        <div class="log__in">
                            <a class="accountbox-trigger" href="#"><i class="zmdi zmdi-account-o"></i><span> ${sessionScope.login}</span></a>
                            
                                
                        </div>
                         <div class="shopping__cart">
                            <a href="FrontController?action=DeslogarConta" class="accountbox-trigger" >Sair</a>
                        </div>
                        <div class="shopping__cart">
                            <a class="minicart-trigger" href="#"><i class="zmdi zmdi-shopping-basket"></i></a>
                            <div class="shop__qun">
                                <span>${sessionScope.pedidos.size()}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Mobile Menu -->
            <div class="mobile-menu d-block d-lg-none"></div>
            <!-- Mobile Menu -->
        </div>
    </div>
    <!-- End Mainmenu Area -->
</header>
<!-- End Header Area -->
<!-- Cartbox -->
<div class="cartbox-wrap">
    <div class="cartbox text-right">
        <button class="cartbox-close"><i class="zmdi zmdi-close"></i></button>
        <div class="cartbox__inner text-left">
            <div class="cartbox__items">
                <c:forEach items="${sessionScope.pedidos}" var="pedido">
                    <!-- Cartbox Single Item -->
                    <div class="cartbox__item">
                        <div class="cartbox__item__thumb">
                            <a href="product-details.html">
                                <img src="${pedido.produto.imagem}" alt="small thumbnail">
                            </a>
                        </div>
                        <div class="cartbox__item__content">
                            <h5><a href="product-details.html" class="product-name">${pedido.produto.nome}</a></h5>
                            <span class="price">R$ ${pedido.produto.getPrecoDeVenda()}</span>
                        </div>
                        <form action="FrontController?action=RemoverProdutoCarrinhoConsumidor&id=${pedido.id}" method="post">
                            <button type="submit" class="cartbox__item__remove">
                                <i class="fa fa-trash"></i>
                            </button>
                        </form>
                    </div><!-- //Cartbox Single Item -->
                </c:forEach>
            </div>
            <div class="cartbox__total">
                <ul>
                    <c:set var="total" scope = "session" value = "${0}" />    
                    <c:forEach items="${sessionScope.pedidos}" var="pedido">
                        <c:set var="total" value="${total + pedido.produto.getPrecoDeVenda()}"/>
                    </c:forEach>
                    <li class="grandtotal">Total<span class="price">R$ ${total}</span></li>
                </ul>
            </div>
            <div class="cartbox__buttons">
                <form action="FrontController?action=PrepararFinalizarCompraConsumidor" method="post">
                    <button type="submit" class="food__btn">Carrinho</button>
                </form>
            </div>
        </div>
    </div>
</div><!-- //Cartbox -->