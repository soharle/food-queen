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
                                <li class="drop"><a href="menu-list.html">Produtos</a>
                                    <ul class="dropdown__menu">
                                        <li><a href="menu-list.html">Menu List</a></li>
                                        <li><a href="menu-details.html">Menu Details</a></li>
                                    </ul>
                                </li>
                                <li class="drop"><a href="#">Pages</a>
                                    <ul class="dropdown__menu">
                                        <li><a href="service.html">Service</a></li>
                                        <li><a href="cart.html">Cart Page</a></li>
                                        <li><a href="checkout.html">Checkout Page</a></li>
                                        <li><a href="contact.html">Contact Page</a></li>
                                    </ul>
                                </li>
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
                            <a class="minicart-trigger" href="#"><i class="zmdi zmdi-shopping-basket"></i></a>
                            <div class="shop__qun">
                                <span>${sessionScope.pedidos.count()}</span>
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
                            <p>Quantidade: <span>01</span></p>
                            <span class="price">${pedido.produto.preco}</span>
                        </div>
                        <form action="FrontController?DeletarProdutoCarrinhoConsumidor&id=${pedido.id}" method="post">
                            <button type="submit" class="cartbox__item__remove">
                                <i class="fa fa-trash"></i>
                            </button>
                        </form>
                    </div><!-- //Cartbox Single Item -->
                </c:forEach>
            </div>
            <div class="cartbox__total">
                <ul>
                    <li class="grandtotal">Total<span class="price">${sessionScope.carrinho.valor}</span></li>
                </ul>
            </div>
            <div class="cartbox__buttons">
                <form action="FrontController?action=PreparaCarrinhoConsumidor" method="post">
                    <button type="submit" class="food__btn">Finalizar compra</button>
                </form>
            </div>
        </div>
    </div>
</div><!-- //Cartbox -->