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
                        <div class="form-group text-right">
                            <button type="submit" class="btn btn-lg btn-success">Cadastrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
