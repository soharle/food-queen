<%-- 
    Document   : promocoes
    Created on : 10/04/2019, 15:01:38
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Promoções</title>
        <%@ include file="shared/head.jsp" %>
    </head>
    <body>
        <%@ include file="shared/navbar.jsp" %>
        <div class="container mt-5">
            <table class="table table-borderless">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Desconto</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="txtNome" id="txtNome" class="form-control"/></td>
                        <td><input type="text" name="txtDesconto" id="txtDesconto" class="form-control"/></td>
                        <td><select class="custom-select" name="optTipo" id="optTipo">
                                <option value="valorBruto">Valor bruto</option>
                                <option value="percentual">Percentual</option>
                            </select>
                        </td>
                        <td><a href="FrontController?action=CadastrarPromocaoLoja" class="btn btn-sm btn-outline-Success">Cadastrar</a></td>
                    </tr>
                    <tr>
                        <c:forEach items="${promocoes}" var="promocao">
                            <td>${promocao.nome}</td>
                            <td>${promocao.desconto}</td>
                            <td>${promocao.tipo}</td>
                            <td><a href="FrontController?action=LerPromocaoLoja&id=${promocao.id}" class="btn btn-sm btn-outline-secondary">Editar</a>
                                <a href="FrontController?action=DeletarPromocaoLoja&id=${promocao.id}" class="btn btn-sm btn-outline-danger">Deletar</a></td>
                            </c:forEach>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
