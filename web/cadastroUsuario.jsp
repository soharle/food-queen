<%-- 
    Document   : cadastro-usuario
    Created on : 10/04/2019, 12:05:31
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h3 class="h4 text-center">Cadastro de usuário</h3>
                    <form action="FrontController?action=SalvarConsumidor" method="post">
                        <h3 class="mb-3 mt-5">Dados</h3>
                        <div class="form-group">
                            <label for="txtLogin">Login</label>
                            <input type="text" class="form-control" id="txtLogin" name="txtLogin">
                        </div>
                        <div class="form-group">
                            <label for="txtSenha">Senha</label>
                            <input type="text" class="form-control" id="txtSenha" name="txtSenha">
                        </div>
                        <div class="form-group">
                            <label for="txtNome">Nome</label>
                            <input type="text" class="form-control" id="txtNome" name="txtNome">
                        </div>
                        <div class="form-group">
                            <label for="txtNascimento">Data de nascimento</label>
                            <input type="text" class="form-control" id="txtNascimento" name="txtNascimento">
                        </div>
                        <div class="form-group">
                            <label for="txtCpf">CPF</label>
                            <input type="text" class="form-control" id="txtCpf" name="txtCpf">
                        </div>
                        <h3 class="mb-3 mt-5">Contato</h3>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-3">
                                    <label for="txtDdd">DDD</label>
                                    <input type="text" class="form-control" id="txtDdd" name="txtDdd">
                                </div>
                                <div class="col-md-9">
                                    <label for="txtTelefone">Telefone</label>
                                    <input type="text" class="form-control" id="txtTelefone" name="txtTelefone">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-9">
                                    <label for="txtTelefone2">Telefone complementar</label>
                                    <input type="text" class="form-control" id="txtTelefone2" name="txtTelefone2">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtEmail">Email</label>
                            <input type="text" class="form-control" id="txtEmail" name="txtEmail">
                        </div>
                        <h3 class="mb-3 mt-5">Endereço</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="txtLogradouro">Logradouro</label>
                                    <input type="text" name="txtLogradouro" id="txtLogradouro" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="txtNumero">Numero</label>
                                    <input type="text" name="txtNumero" id="txtNumero" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtComplemento">Complemento</label>
                                    <input type="text" name="txtComplemento" id="txtComplemento" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtBairro">Bairro</label>
                                    <input type="text" name="txtBairro" id="txtBairro" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtCidade">Cidade</label>
                                    <input type="text" name="txtCidade" id="txtCidade" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtEstado">Estado</label>
                                    <input type="text" name="txtEstado" id="txtEstado" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtPais">Pais</label>
                                    <input type="text" name="txtPais" id="txtPais" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtCep">CEP</label>
                                    <input type="text" name="txtCep" id="txtCep" class="form-control"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group text-right">
                            <button type="submit" class="btn btn-lg btn-success">Cadastrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
