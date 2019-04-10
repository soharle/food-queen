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
                        <th scope="col">Valor</th>
                        <th scope="col">Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach items="${promocoes}" var="promocao">
                            <td>${promocao.nome}</td>
                            <td>${promocao.desconto}</td>
                            <td>${promocao.tipo}</td>
                        </c:forEach>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
