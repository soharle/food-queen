<%-- 
    Document   : cadastro-loja
    Created on : 10/04/2019, 12:05:43
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de usuário</title>
        <%@ include file="./shared/head.jsp" %>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-0 col-md-4 col-lg-4" style="background-image: url('./assets/images/bg-login.jpg');">

            </div>
            <div class="col-sm-12 col-md-8 col-lg-8">
                <div class="container px-5 my-5">
                    <h3 class="h4 text-center">Cadastro de Restaurante</h3>
                    <form action="FrontController?action=SalvarLoja" method="post">
                        <div class="form-group">
                            <label for="txtLogin">Login</label>
                            <input type="text" class="form-control" id="txtLogin" name="txtLogin">
                        </div>
                        <div class="form-group">
                            <label for="txtSenha">Senha</label>
                            <input type="text" class="form-control" id="txtSenha" name="txtSenha">
                        </div>
                        <div class="row">
                            <div class="col-md-6 text-center">
                                <img src="${loja.imagem}" class="img-fluid profile-image" style="border: 1px solid #f5f5f5;"
                                     alt="">
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtImagem">Nova imagem</label>
                                    <input type="text" name="txtImagem" id="txtImagem" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="txtNome">Nome</label>
                                    <input type="text" name="txtNome" id="txtNome" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="txtCnpj">CNPJ</label>
                                    <input type="text" name="txtCnpj" id="txtCnpj" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="optCategoria">Categoria</label>
                                <select class="custom-select" name="optCategoria" id="optCategoria">
                                    <c:forEach items="${categorias}" var="categoria">
                                        <option value="${categoria.id}"> ${categoria.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="txtDescricao">Descrição</label>
                                    <input type="text" class="form-control" id="txtDescricao" name="txtDescricao" placeholder="Descrição" />

                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtLogradouro">Logradouro</label>
                                    <input type="text" name="txtLogradouro" id="txtLogradouro" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtNumero">Numero</label>
                                    <input type="text" name="txtNumero" id="txtNumero" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtComplemento">Complemento</label>
                                    <input type="text" name="txtComplemento" id="txtComplemento" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtBairro">Bairro</label>
                                    <input type="text" name="txtBairro" id="txtBairro" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtCidade">Cidade</label>
                                    <input type="text" name="txtCidade" id="txtCidade" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtEstado">Estado</label>
                                    <input type="text" name="txtEstado" id="txtEstado" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtPais">Pais</label>
                                    <input type="text" name="txtPais" id="txtPais" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtCep">CEP</label>
                                    <input type="text" name="txtCep" id="txtCep" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtDdd">DDD</label>
                                    <input type="text" name="txtDdd" id="txtDdd" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtTelefone">Telefone</label>
                                    <input type="text" name="txtTelefone" id="txtTelefone" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtEmail">Email</label>
                                    <input type="text" name="txtEmail" id="txtEmail" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtTelefoneComplementar">Telefone complementar</label>
                                    <input type="text" name="txtTelefoneComplementar" id="txtTelefoneComplementar" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group text-right">
                            <button type="submit" value="submit" class="btn btn-lg btn-success">Cadastrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
