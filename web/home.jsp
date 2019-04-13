<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>

    <head>
        <title>FoodQueen - Delivery de comida</title>
        <%@ include file="./shared/head.jsp" %>
    </head>
    <body>
        <div class="wrapper" id="wrapper">
            <%@ include file="./shared/navbar.jsp" %>

            <!-- Start Single Slide -->
            <div class="slide fullscreen" style="background-image: url('./assets/images/bg-food.jpg');">
                <div class="container ">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <div class="slider__content">
                                <div class="slider__inner">
                                    <h2>FoodQueen</h2>
                                    <h1>Delivery de comida</h1>
                                    <div class="slider__input">
                                        <input class="res__search" type="text" placeholder="O que deseja?">
                                        <div class="src__btn">
                                            <a href="#">Buscar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Slider Area -->
            <!-- Start Food Category -->
            <section class=" section-padding--lg" style="background-color: #ffffff;">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-lg-12">
                            <div class="section__title service__align--left">
                                <p>Vamos organizar!</p>
                                <h2 class="title__line">Busque comida pela categoria que preferir! </h2>
                            </div>
                        </div>
                    </div>
                    <div class="food__category__wrapper mt--40">
                        <div class="row">
                            <c:forEach items="${categorias}" var="categoria">
                                <div class="col-lg-3 col-md-4 col-sm-12">
                                    <div class="food__item foo">
                                        <div>
                                            <h2><a href="menu-details.html">${categoria.nome}</a></h2>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </section>
            <section class="bg-image--3 section-pt--lg" style="background-image: url('./assets/images/bg-wood.jpg');">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-lg-12">
                            <div class="slider__content" style="color: #ffffff;">
                                <div class="slider__inner">
                                    <h2>FoodQueen</h2>
                                    <h1>O pedido do tamanho da sua fome!</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="special__food__menu mt-0">
                    <div class="food__menu__prl bg-image--4">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="fd__tab__content tab-content" id="nav-tabContent">
                                        <div class="single__tab__panel tab-pane fade show active" id="nav-coffee"
                                             role="tabpanel">
                                            <div class="tab__content__wrap">
                                                <div class="single__tab__content row">

                                                    <c:forEach items="${produtos}" var="produto">
                                                        <div class="food__menu col-md-3">
                                                            <div class="food__menu__thumb">
                                                                <a href="menu-details.html">
                                                                    <img src="${produto.imagem}" alt="product images" style="max-height: 105px; max-width: 109px;">
                                                                </a>
                                                            </div>
                                                            <div class="food__menu__details px-2">
                                                                <div class="fd__menu__title__prize">
                                                                    <h4><a href="menu-details.html">${produto.nome}</a></h4>
                                                                    <span class="menu__prize">$ ${produto.preco}</span>
                                                                </div>
                                                                <div class="fd__menu__details">
                                                                    <div class="delivery__time__rating">
                                                                        <p>${produto.descricao}</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
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