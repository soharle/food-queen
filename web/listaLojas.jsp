<%-- 
    Document   : listaLojas
    Created on : 16/04/2019, 09:00:16
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FoodQueen - lista de Lojas</title>
        <%@ include file="./shared/head.jsp" %>
    </head>
    <body>
        <div class="wrapper" id="wrapper">
            <%@ include file="./shared/navbar.jsp" %>
            <div class="ht__bradcaump__area bg-image--18">
                <div class="ht__bradcaump__wrap d-flex align-items-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <div class="bradcaump__inner text-center">
                                    <h2 class="bradcaump-title">Lista de Lojas</h2>
                                    <nav class="bradcaump-inner">
                                        <a class="breadcrumb-item" href="FrontController?action=PrepararHomeConsumidor">Início</a>
                                        <span class="brd-separetor"><i class="zmdi zmdi-long-arrow-right"></i></span>
                                        <span class="breadcrumb-item active">Lista de Lojas</span>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Start Menu Grid Area -->
            <section class="food__menu__grid__area section-padding--lg">
                <div class="container">
                    <div class="row mt--30">
                        <div class="col-lg-12">
                            <div class="fd__tab__content tab-content" id="nav-tabContent">
                                <!-- Start Single Content -->
                                <div class="food__list__tab__content tab-pane fade show active" id="nav-all" role="tabpanel">
                                    <!-- Start Single Food -->
                                    <c:forEach items="${lojas}" var="loja">
                                        <div class="single__food__list d-flex wow fadeInUp py-5">
                                            <div class="food__list__thumb">
                                                <a href="menu-details.html">
                                                    <img src="${loja.imagem}" style="max-width:468px;" alt="">
                                                </a>
                                            </div>
                                            <div class="food__list__inner d-flex align-items-center justify-content-between">
                                                <div class="food__list__details">
                                                    <h2><a href="menu-details.html">${loja.nome}</a></h2>
                                                    <p>${loja.descricao}</p>
                                                    <div class="list__btn">
                                                        <a class="food__btn grey--btn theme--hover" href="FrontController?action=PrepararListaProdutosLojaConsumidor&id=${loja.id}">Ver produtos</a>
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
            </section>
        </div>
    </body>
    <%@ include file="./shared/footer.jsp" %>
</html>
