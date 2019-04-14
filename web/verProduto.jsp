<%-- 
    Document   : verProduto
    Created on : 13/04/2019, 14:42:20
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FoodQueen - lista de produtos</title>
        <%@ include file="./shared/head.jsp" %>
    </head>
    <body>
        <div class="wrapper" id="wrapper">
            <%@ include file="./shared/navbar.jsp" %>

            <!-- Start Bradcaump area -->
            <div class="ht__bradcaump__area bg-image--18">
                <div class="ht__bradcaump__wrap d-flex align-items-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <div class="bradcaump__inner text-center">
                                    <h2 class="bradcaump-title">Detalhes do produto</h2>
                                    <nav class="bradcaump-inner">
                                        <a class="breadcrumb-item" href="FrontController?action=PrepararHomeConsumidor">Início</a>
                                        <span class="brd-separetor"><i class="zmdi zmdi-long-arrow-right"></i></span>
                                        <span class="breadcrumb-item active">Detalhes do produto</span>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Bradcaump area --> 

            <!-- Start Blog List View Area -->
            <section class="blog__list__view section-padding--lg menudetails-right-sidebar bg--white">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-12 col-sm-12">
                            <div class="food__menu__container">
                                <div class="food__menu__inner d-flex flex-wrap flex-md-nowrap flex-lg-nowrap">
                                    <div class="food__menu__thumb">
                                        <img src="./assets/images/bg-login.jpg" style="max-height: 370px; max-width: 380px;" alt="images">
                                    </div>
                                    <div class="food__menu__details">
                                        <div class="food__menu__content">
                                            <h2>Nome do produto</h2>
                                            <ul class="food__dtl__prize d-flex">
                                                <li class="old__prize" style="text-decoration: line-through;">$50</li>
                                                <li>$40</li>
                                            </ul>
                                            <p>Descrição</p>
                                            <div class="product-action-wrap">
                                                <div class="prodict-statas"><span>Categoria: Taco</span></div>
                                                <div class="product-quantity">
                                                    <form id='myform' method='POST' action='#'>
                                                        <div class="product-quantity">
                                                            <div class="cart-plus-minus">
                                                                <input class="cart-plus-minus-box" type="text" name="qtybutton" value="02">
                                                                <div class="add__to__cart__btn">
                                                                    <a class="food__btn" href="cart.html">Comprar</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-12 col-sm-12 md--mt--40 sm--mt--40">
                            <div class="food_sidebar">
                                <!-- Start Recent Post -->
                                <div class="food__recent__post">
                                    <h4 class="side__title">Loja</h4>
                                    <div class="recent__post__wrap">
                                        <!-- Start Single Post -->
                                        <div class="single__recent__post d-flex">
                                            <div class="recent__post__thumb">
                                                <a href="blog-details.html">
                                                    <img src="./assets/images/bg-login.jpg" style="height: 100px; width: 120px;" alt="post images">
                                                </a>
                                            </div>
                                            <div class="recent__post__details">
                                                <h3><a href="blog-details.html">Loja</a></h3>
                                                <h4><a href="blog-details.html">Endereço da loja</a></h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
    <%@ include file="./shared/footer.jsp" %>
</html>
