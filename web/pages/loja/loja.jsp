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
            <form action="FrontController?action=SalvarLoja" method="post">
            </c:if>
            <c:if test="${acao=='Editar'}">
                <form action="FrontController?action=AtualizaLoja&id=${loja.id}" method="post">
                </c:if>
                <table>
                    <tr>
                        <td>Nome</td>
                        <td><input type="text" name="textNome" <c:if test="${loja.nome != null}"> value="${loja.nome}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>CNPJ</td>
                            <td><input type="text" name="textCnpj" <c:if test="${loja.cnpj != null}"> value="${loja.cnpj}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Descrição do estabelecimento</td>
                            <td><input type="text" name="textDescricao" <c:if test="${loja.descricao != null}"> value="${loja.descricao}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Endereço</td>
                            <td>
                                <select name="enderecoLojaId">
                                    <c:forEach items="${enderecos}" var="endereco">
                                        <option value="${endereco.id}">${endereco.logradouro} - ${endereco.numero} - ${endereco.cidade}</option>  
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="enderecoLojaIdx" <c:if test="${loja.enderecoLoja.id != null}"> value="${loja.enderecoLoja.id}"</c:if> />
                            </td>
                        </tr>
                        <tr>
                            <td>Conta</td>
                            <td>
                                <select name="contaId">
                                    <c:forEach items="${contas}" var="conta">
                                        <option value="${conta.id}">${conta.login} - ${conta.tipo}</option>  
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="contaIdx" <c:if test="${loja.conta.id != null}"> value="${loja.conta.id}"</c:if> />
                            </td>
                        </tr>
                        <tr>
                            <td>Contato</td>
                            <td>
                                <select name="contatoId">
                                    <c:forEach items="${contatos}" var="contato">
                                        <option value="${contato.id}">${contato.email} - ${cotnato.telefone}</option>  
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="contatoIdx" <c:if test="${loja.contato.id != null}"> value="${loja.contato.id}"</c:if> />
                            </td>
                        </tr>
                        <tr>
                            <td>Categoria</td>
                            <td>
                                <select name="categoriaId">
                                    <c:forEach items="${categorias}" var="categoria">
                                        <option value="${categoria.id}">${categoria.nome}</option>  
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="categoriaIdx" <c:if test="${loja.categoria.id != null}"> value="${loja.categoria.id}"</c:if> />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="${acao}" /></td>
                    </tr>
                </table>
            </form>
    </body>
</html>

