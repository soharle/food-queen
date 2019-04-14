<%-- 
    Document   : editarEndereço
    Created on : 13/04/2019, 16:14:50
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FoodQueen - Editar endereço</title>
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
                                    <h2 class="bradcaump-title">Editar endereço</h2>
                                    <nav class="bradcaump-inner">
                                        <a class="breadcrumb-item" href="FrontController?action=PrepararHomeConsumidor">Início</a>
                                        <span class="brd-separetor"><i class="zmdi zmdi-long-arrow-right"></i></span>
                                        <span class="breadcrumb-item active">Editar endereço</span>
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
                            <form action="FrontController?action=EditarEnderecoConsumidor" method="post">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="txtLogradouro">Logradouro</label>
                                            <input type="text" name="txtLogradouro" id="txtLogradouro" <c:if
                                                       test="${consumidor.endereco.logradouro != null}"> value="${consumidor.endereco.logradouro}"
                                                   </c:if> class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="txtNumero">Numero</label>
                                            <input type="text" name="txtNumero" id="txtNumero" <c:if
                                                       test="${consumidor.endereco.numero != null}"> value="${consumidor.endereco.numero}"</c:if>
                                                       class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group mt-5">
                                                <label for="txtComplemento">Complemento</label>
                                                <input type="text" name="txtComplemento" id="txtComplemento" <c:if
                                                       test="${consumidor.endereco.complemento != null}"> value="${consumidor.endereco.complemento}"
                                                   </c:if> class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group mt-5">
                                            <label for="txtBairro">Bairro</label>
                                            <input type="text" name="txtBairro" id="txtBairro" <c:if
                                                       test="${consumidor.endereco.bairro != null}"> value="${consumidor.endereco.bairro}"</c:if>
                                                       class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group mt-5">
                                                <label for="txtCidade">Cidade</label>
                                                <input type="text" name="txtCidade" id="txtCidade" <c:if
                                                       test="${consumidor.endereco.cidade != null}"> value="${consumidor.endereco.cidade}"</c:if>
                                                       class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group mt-5">
                                                <label for="txtEstado">Estado</label>
                                                <input type="text" name="txtEstado" id="txtEstado" <c:if
                                                       test="${consumidor.endereco.estado != null}"> value="${consumidor.endereco.estado}"</c:if>
                                                       class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group mt-5">
                                                <label for="txtPais">Pais</label>
                                                <input type="text" name="txtPais" id="txtPais" <c:if
                                                       test="${consumidor.endereco.pais != null}"> value="${consumidor.endereco.pais}"</c:if>
                                                       class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group mt-5">
                                                <label for="txtCep">CEP</label>
                                                <input type="text" name="txtCep" id="txtCep" <c:if test="${consumidor.endereco.cep != null}">
                                                   value="${consumidor.endereco.cep}"</c:if> class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group text-right">
                                        <button type="submit" class="btn btn-lg btn-success">Salvar</button>
                                        <a class="btn btn-lg btn-danger" href="FrontController?action=PrepararHomeConsumidor">Cancelar</a>
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
