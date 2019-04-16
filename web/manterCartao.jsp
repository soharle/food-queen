<%-- 
    Document   : manterCartao
    Created on : 13/04/2019, 16:36:15
    Author     : Gabriel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

    <head>
        <title>FoodQueen - Editar dados</title>
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
                                    <h2 class="bradcaump-title">Editar cartões</h2>
                                    <nav class="bradcaump-inner">
                                        <a class="breadcrumb-item" href="FrontController?action=PrepararHomeConsumidor">Início</a>
                                        <span class="brd-separetor"><i class="zmdi zmdi-long-arrow-right"></i></span>
                                        <span class="breadcrumb-item active">Editar cartões</span>
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
                            <c:forEach items="${cartoes}" var="cartao">
                                <div class="single-accordion">
                                    <a class="accordion-head collapsed" data-toggle="collapse" data-parent="#checkout-accordion" href="#payment-method">${cartao.numero}</a>
                                    <div id="payment-method" class="collapse">
                                        <div class="accordion-body payment-method fix">
                                            <div class="row text-center">
                                                <div class="input-box col-6 mb--20">
                                                    <label>Titular: </label>
                                                    ${cartao.titular}
                                                </div>
                                                <div class="input-box col-6 mb--20">
                                                    <label>Número: </label>
                                                    ${cartao.numero}
                                                </div>
                                                <div class="input-box col-12">
                                                    <div class="input-box col-12 mb--20">
                                                        <label>Data de validade: </label>
                                                        ${cartao.validade}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            <form action="FrontController?action=SalvarCartaoConsumidor" method="post">
                                <div class="payment-method fix">
                                    <div class="row">
                                        <div class="input-box col-12 mb--20 mt--20">
                                            <h3 class="text-center">Cadastrar novo</h3>
                                        </div>
                                        <div class="input-box col-12 mb--20">
                                            <label for="txtNome">Nome do titular do cartão</label>
                                            <input type="text" class="form-control" id="txtNome" name="txtNome" />
                                        </div>
                                        <div class="input-box col-12 mb--20">
                                            <label for="txtNumero">Número do cartão</label>
                                            <input type="text" class="form-control" id="txtNumero" name="txtNumero" />
                                        </div>
                                        <div class="input-box col-12">
                                            <div class="row">
                                                <div class="input-box col-12">
                                                    <label>Data de validade</label>
                                                </div>
                                                <div class="input-box col-md-6 col-12 mb--20">
                                                    <select class="form-control" id="optMes" name="optMes">
                                                        <option value="00">Mês</option>
                                                        <option value="01">Jan</option>
                                                        <option value="02">Fev</option>
                                                        <option value="03">Mar</option>
                                                        <option value="04">Abr</option>
                                                        <option value="05">Mai</option>
                                                        <option value="06">Jun</option>
                                                        <option value="07">Jul</option>
                                                        <option value="08">Ago</option>
                                                        <option value="09">Set</option>
                                                        <option value="10">Out</option>
                                                        <option value="11">Nov</option>
                                                        <option value="12">Dez</option>
                                                    </select>
                                                </div>
                                                <div class="input-box col-md-6 col-12 mb--20">
                                                    <select class="form-control" id="optAno" name="optAno">
                                                        <option value="00">Ano</option>
                                                        <option value="19">2019</option>
                                                        <option value="20">2020</option>
                                                        <option value="21">2021</option>
                                                        <option value="22">2022</option>
                                                        <option value="23">2023</option>
                                                        <option value="24">2024</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="input-box col-12">
                                            <label for="txtCod">Código de segurança</label>
                                            <input type="text" class="form-control" id="txtCod" name="txtCod" />
                                        </div>
                                        <div class="input-box col-12 mt-5">
                                            <div class="form-group text-right">
                                                <button type="submit" class="btn btn-md btn-success">Salvar</button>
                                                <a class="btn btn-md btn-danger" href="FrontController?action=PrepararHomeConsumidor">Cancelar</a>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-0 col-md-1 col-lg-2"></div>
                    </div>
                </div>
            </section>
        </div>
    </body>
    <%@ include file="./shared/footer.jsp" %>
</html>