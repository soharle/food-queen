<%-- 
    Document   : listar
    Created on : 28/03/2019, 12:16:08
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Lojas</h1>
            <div>
                <table class="tableCrud">
                    <thead>
                    <th>
                        Id:
                    </th>
                    <th>
                        Nome:
                    </th>
                    <th>
                        Contato:
                    </th>
                    <th>
                    </th>
                    </thead>
                    <tbody>
                    <c:forEach items="${lojas}" var="loja">
                        <tr>
                            <td><c:out value="${loja.id}"/></td>
                        <td><c:out value="${loja.nome}"/></td>
                        <td><c:out value="${loja.contato.telefone}"/></td>
                        <td
                            ><form
                                action="FrontController?action=DeletarCategoria&id=${loja.id}"
                                method="post"
                                >
                                <input type="submit" value="Apagar" /> </form
                            ></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
