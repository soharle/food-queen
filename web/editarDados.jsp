<%-- 
    Document   : editarDados
    Created on : 13/04/2019, 15:58:31
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
                                    <h2 class="bradcaump-title">Editar dados</h2>
                                    <nav class="bradcaump-inner">
                                        <a class="breadcrumb-item" href="FrontController?action=PrepararDadosConsumidor">Início</a>
                                        <span class="brd-separetor"><i class="zmdi zmdi-long-arrow-right"></i></span>
                                        <span class="breadcrumb-item active">Editar dados pessoais</span>
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
                            <form action="FrontController?action=EditarDadosConsumidor" method="post">
                                <div class="form-group">
                                    <label for="txtLogin">Login</label>
                                    <input type="text" class="form-control" <c:if test="${consumidor.conta.login != null}">
                                           value="${consumidor.conta.login}"</c:if> id="txtLogin" name="txtLogin">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtSenha">Senha</label>
                                        <input type="text" class="form-control"  <c:if test="${consumidor.conta.senha != null}">
                                           value="${consumidor.conta.senha}"</c:if> id="txtSenha" name="txtSenha">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNome">Nome</label>
                                        <input type="text" class="form-control"  <c:if test="${consumidor.nome != null}">
                                           value="${consumidor.nome}"</c:if> id="txtNome" name="txtNome">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNascimento">Data de nascimento</label>
                                        <input type="text" class="form-control" <c:if test="${consumidor.nascimento != null}">
                                           value="${consumidor.nascimento}"</c:if> id="txtNascimento" name="txtNascimento">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtCpf">CPF</label>
                                        <input type="text" class="form-control" <c:if test="${consumidor.cpf != null}">
                                           value="${consumidor.cpf}"</c:if> id="txtCpf" name="txtCpf">
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label for="txtDdd">DDD</label>
                                                <input type="text" class="form-control" <c:if test="${consumidor.contato.ddd != null}">
                                                   value="${consumidor.contato.ddd}"</c:if> id="txtDdd" name="txtDdd">
                                            </div>
                                            <div class="col-md-9">
                                                <label for="txtTelefone">Telefone</label>
                                                <input type="text" class="form-control" <c:if test="${consumidor.contato.telefone != null}">
                                                   value="${consumidor.contato.telefone}"</c:if> id="txtTelefone" name="txtTelefone">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-3">
                                            </div>
                                            <div class="col-md-9">
                                                <label for="txtTelefone2">Telefone complementar</label>
                                                <input type="text" class="form-control" <c:if test="${consumidor.contato.telefoneComplementar != null}">
                                                   value="${consumidor.contato.telefoneComplementar}"</c:if> id="txtComplementar" name="txtComplementar">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtEmail">Email</label>
                                        <input type="text" class="form-control" id="txtEmail" <c:if test="${consumidor.contato.email != null}">
                                           value="${consumidor.contato.email}"</c:if> name="txtEmail">
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
