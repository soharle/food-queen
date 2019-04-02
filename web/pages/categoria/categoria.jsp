<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title> <c:out value="${acao}"/> Categoria</title>
  </head>
  <body>
    <h2> <c:out value="${acao}" /></h2>
    <c:if test="${acao=='Cadastrar'}">
      <form action="FrontController?action=SalvarCategoria" method="post">
    </c:if>
    <c:if test="${acao=='Editar'}">
      <form action="FrontController?action=AtualizarCategoria&id=${categoria.id}" method="post">
    </c:if>
      <table>
        <tr>
          <td>Nome da categoria</td>
          <td><input type="text" name="txtNome" <c:if test="${categoria.nome != null}"> value="${categoria.nome}"</c:if> /></td>
        </tr>
        <tr>
          <td><input type="submit" value="${acao}" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>
