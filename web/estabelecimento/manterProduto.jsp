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
            <div class="container mt-5">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-item nav-link active" id="nav-produto-tab" data-toggle="tab" href="#nav-produto" role="tab" aria-controls="nav-produto" aria-selected="true"><c:if test="${acao == 'editar'}">Editar </c:if>Produto</a>
                        </li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="nav-produto" role="tabpanel" aria-labelledby="nav-produto-tab">
                        <div class="row">
                            <div class="col-md-12">
                            <c:if test="${acao == 'criar'}"> 
                                <form class="container" action="FrontController?action=SalvarProdutoLoja" method="post"> 
                                </c:if>
                                <c:if test="${acao != 'criar'}"> 
                                    <form class="container" action="FrontController?action=EditarProdutoLoja" method="post"> 
                                    </c:if>
                                    <input type="text" name="txtId" value="${produto.id}" hidden>
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
                                                <label for="optPromocao">Promoção</label>
                                                <select class="custom-select" name="optPromocao" id="optPromocao">
                                                <c:forEach items="${promocoes}" var="promocao">
                                                    <option <c:if test="${produto.promocao.getId() == promocao.getId()}"> selected </c:if> value="${promocao.getId()}"> ${promocao.getNome()} - ${promocao.getDesconto()}</option>
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
                                            <a href="FrontController?action=PrepararProdutosLoja" class="btn btn-md btn-danger">Cancelar</a>
                                        </div>
                                    </div>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
