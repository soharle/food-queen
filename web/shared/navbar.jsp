<%-- 
    Document   : navbar
    Created on : 04/04/2019, 09:25:53
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Start Header Area -->
<header class="htc__header bg--white">
    <!-- Start Mainmenu Area -->
    <div id="sticky-header-with-topbar" class="mainmenu__wrap sticky__header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2 col-sm-4 col-md-6 order-1 order-lg-1">
                    <div class="logo">
                        <a href="index.html">
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
                            <a class="accountbox-trigger" href="#"><i class="zmdi zmdi-account-o"></i><span> ${sessionScope.usuario.nome}</span></a>
                        </div>
                        <div class="shopping__cart">
                            <a class="minicart-trigger" href="#"><i class="zmdi zmdi-shopping-basket"></i></a>
                            <div class="shop__qun">
                                <span>${sessionScope.carrinho.count}</span>
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