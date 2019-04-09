<%-- 
    Document   : editarDados
    Created on : 09/04/2019, 15:09:29
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Admin - Home</title>
        <%@ include file="shared/head.jsp" %>
    </head>
    <body>
        <%@ include file="shared/navbar.jsp" %>
        <div class="container mt-5">
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" href="#dados" role="tab" id="defaultOpen" data-toggle="tab">Dados</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#endereco" role="tab" id="second" data-toggle="tab">Endereço</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#contato" role="tab" data-toggle="tab">Contato</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#senha" role="tab" data-toggle="tab">Senha</a>
                </li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade active container-fluid pt-1" id="dados">
                    <form class="container">
                        <div class="row">
                            <div class="col-md-6 text-center">
                                <img src="${loja.imagem}" class="img-fluid profile-image" style="border: 1px solid #f5f5f5;" alt="">
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtImagem">Nova imagem</label>
                                    <input type="text" name="txtImagem" id="txtImagem" <c:if test="${loja.imagem != null}"> value="${loja.imagem}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="txtNome">Nome</label>
                                        <input type="text" name="txtNome" id="txtNome" <c:if test="${loja.nome != null}"> value="${loja.nome}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="txtCnpj">CNPJ</label>
                                        <input type="text" name="txtCnpj" id="txtCnpj" <c:if test="${loja.cnpj != null}"> value="${loja.cnpj}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="optCategoria">Descrição</label>
                                    <select class="custom-select" name="optCategoria" id="optCategoria">
                                    <c:forEach items="${categorias}" var="categoria">
                                        <option <c:if test="${loja.categoria.id == categoria.id}"> selected </c:if> value="${categoria.id}"> ${categoria.nome}</option>  
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="txtDescricao">Descrição</label>
                                    <textarea class="form-control" id="txtDescricao" name="txtDescricao" 
                                              <c:if test="${loja.descricao != null}"> value="${loja.descricao}"</c:if> 
                                              placeholder="Descrição">
                                    </textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-right">
                                <button type="submit" class="btn btn-md btn-success">Salvar</button>
                                <button type="submit" class="btn btn-md btn-danger">Cancelar</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="endereco">
                    <form class="container">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtImagem">Logradouro</label>
                                    <input type="text" name="txtLogradouro" id="txtImagem" <c:if test="${loja.imagem != null}"> value="${loja.imagem}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="contato">
                    <form class="container">
                        <div class="row">

                        </div>
                    </form>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="senha">
                    <form class="container">
                        <div class="row">

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            document.getElementById("second").click();
            document.getElementById("defaultOpen").click();
        });
    </script>
</html>
