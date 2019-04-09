<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Index</title>
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
                            <div class="col-lg-3 col-md-4 col-sm-12">
                                <div class="food__item foo">
                                    <div>
                                        <h2><a href="menu-details.html">Breakfast Iteam</a></h2>
                                    </div>
                                </div>
                            </div>
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
                <div class="special__food__menu mt--50">
                    <div class="food__menu__prl">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="fd__tab__content tab-content" id="nav-tabContent">
                                        <div class="single__tab__panel tab-pane fade show active" id="nav-coffee"
                                             role="tabpanel">
                                            <div class="tab__content__wrap">
                                                <div class="single__tab__content">
                                                    <div class="food__menu">
                                                        <div class="food__menu__thumb">
                                                            <a href="menu-details.html">
                                                                <img src="images/product/sm-img/1.jpg" alt="product images">
                                                            </a>
                                                        </div>
                                                        <div class="food__menu__details">
                                                            <div class="fd__menu__title__prize">
                                                                <h4><a href="menu-details.html">Maxican Food Fev</a></h4>
                                                                <span class="menu__prize">$15</span>
                                                            </div>
                                                            <div class="fd__menu__details">
                                                                <p>Food Type : Chicken Stack</p>
                                                                <div class="delivery__time__rating">
                                                                    <p>Delivery Time : 60 min, Delivery Cost : Free</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
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
            <!-- End Special Menu -->
        </div>
    </body>

</html>