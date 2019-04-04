<%-- 
    Document   : loja
    Created on : 28/03/2019, 14:19:42
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title> <c:out value="${acao}"/> Loja</title>
    </head>
    <body>
        <h2> <c:out value="${acao}" /></h2>
        <c:if test="${acao=='Cadastrar'}">
            <form action="FrontController?action=SalvarLoja" method="post" enctype="multipart/form-data">
                <input type="file" name="file" value="Carregar imagem"/>
            </c:if>
            <c:if test="${acao=='Editar'}">
                <form action="FrontController?action=AtualizarLoja&id=${loja.id}" 
                      enctype="multipart/form-data" method="post">

                    <img src="${loja.imagem}" alt="imagem da loja"/>
                    <input type="file" name="file" value="Atualizar imagem"/>
                </c:if>

                <table>
                    <tr>
                        <td>Nome</td>
                        <td><input type="text" name="txtNome" <c:if test="${loja.nome != null}"> value="${loja.nome}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>CNPJ</td>
                            <td><input type="text" name="txtCnpj" <c:if test="${loja.cnpj != null}"> value="${loja.cnpj}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Descrição do estabelecimento</td>
                            <td><input type="text" name="txtDescricao" <c:if test="${loja.descricao != null}"> value="${loja.descricao}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Endereço</td>
                            <td>
                                <select name="optEnderecoLoja">
                                <c:forEach items="${enderecosLoja}" var="enderecoLoja">
                                    <option value="${enderecoLoja.id}" <c:if test="${enderecoLoja.id == loja.enderecoLoja.id}"> selected </c:if>>${enderecoLoja.logradouro} - ${enderecoLoja.numero} - ${enderecoLoja.cidade}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Conta</td>
                        <td>
                            <select name="optConta">
                                <c:forEach items="${contas}" var="conta">
                                    <option value="${conta.id}" <c:if test="${conta.id == loja.conta.id}"> selected </c:if>>${conta.login} - ${conta.tipo}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Contato</td>
                        <td>
                            <select name="optContato">
                                <c:forEach items="${contatos}" var="contato">
                                    <option value="${contato.id}" <c:if test="${contato.id == loja.contato.id}"> selected </c:if>>${contato.email} - ${cotnato.telefone}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <td>
                            <select name="optCategoria">
                                <c:forEach items="${categorias}" var="categoria">
                                    <option value="${categoria.id}" <c:if test="${categoria.id == loja.categoria.id}"> selected </c:if>>${categoria.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="${acao}" /></td>
                    </tr>
                </table>
            </form>
    </body>
</html>

