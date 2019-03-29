<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title> <c:out value="${acao}"/> Endereço da Loja</title>
    </head>
    <body>
        <h2> <c:out value="${acao}" /></h2>
        <c:if test="${acao=='Cadastrar'}">
            <form action="FrontController?action=SalvarEnderecoLoja" method="post">
            </c:if>
            <c:if test="${acao=='Editar'}">
                <form action="FrontController?action=AtualizarEnderecoLoja&id=${enderecoLoja.id}" method="post">
                </c:if>
                <table>
                    <tr>
                        <td>CEP</td>
                        <td><input type="text" name="txtCep" <c:if test="${enderecoLoja.cep != null}"> value="${enderecoLoja.cep}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Logradouro</td>
                            <td><input type="text" name="txtLogradouro" <c:if test="${enderecoLoja.logradouro != null}"> value="${enderecoLoja.logradouro}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Numero</td>
                            <td><input type="text" name="txtNumero" <c:if test="${enderecoLoja.numero != null}"> value="${enderecoLoja.numero}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Complemento</td>
                            <td><input type="text" name="txtComplemento" <c:if test="${enderecoLoja.complemento != null}"> value="${enderecoLoja.complemento}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Bairro</td>
                            <td><input type="text" name="txtBairro" <c:if test="${enderecoLoja.bairro != null}"> value="${enderecoLoja.bairro}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Cidade</td>
                            <td><input type="text" name="txtCidade" <c:if test="${enderecoLoja.cidade != null}"> value="${enderecoLoja.cidade}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Estado</td>
                            <td><input type="text" name="txtEstado" <c:if test="${enderecoLoja.estado != null}"> value="${enderecoLoja.estado}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td>Pais</td>
                            <td><input type="text" name="txtPais" <c:if test="${enderecoLoja.pais != null}"> value="${enderecoLoja.pais}"</c:if> /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="${acao}" /></td>
                    </tr>
                </table>
            </form>
    </body>
</html>
