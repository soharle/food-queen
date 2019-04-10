<%-- 
    Document   : manterProduto
    Created on : 10/04/2019, 16:35:09
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Produtos</title>
        <%@ include file="shared/head.jsp" %>
    </head>
    <body>
        <%@ include file="shared/navbar.jsp" %>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-12">
                    <form class="container" action="FrontController?action=EditarDadosLoja" method="post">
                        <div class="row">
                            <div class="col-md-6 text-center">
                                <img src="${produto.imagem}" class="img-fluid profile-image" style="border: 1px solid #f5f5f5;"
                                     alt="">
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtImagem">Nova imagem</label>
                                    <input type="text" name="txtImagem" id="txtImagem" <c:if test="${produto.imagem != null}">
                                           value="${produto.imagem}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="txtNome">Nome</label>
                                        <input type="text" name="txtNome" id="txtNome" <c:if test="${produto.nome != null}">
                                           value="${produto.nome}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="txtPreco">Preço</label>
                                        <input type="text" name="txtPreco" id="txtPreco" <c:if test="${produto.preco != null}">
                                           value="${produto.preco}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="optCategoria">Disponível</label>
                                    <select class="custom-select" name="optCategoria" id="optCategoria">
                                        <option value="0">Indisponível</option>                                    
                                        <option value="1">Disponível</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <label for="optCategoria">Promoção</label>
                                    <select class="custom-select" name="optCategoria" id="optCategoria">
                                        <option value="0"> </option>
                                    <c:forEach items="${promocoes}" var="promocao">
                                        <option <c:if test="${produto.promocao.id == promocao.id}"> selected </c:if> value="${categoria.id}"> ${categoria.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="txtDescricao">Descrição</label>
                                    <input type="text" class="form-control" id="txtDescricao" name="txtDescricao" <c:if
                                               test="${produto.descricao != null}"> value="${produto.descricao}"</c:if> placeholder="Descrição" />

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
            </div>
        </div>
    </body>
</html>
