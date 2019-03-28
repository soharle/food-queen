<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title> <c:out value="${acao}"/> Contato</title>
  </head>
  <body>
    <h2> <c:out value="${acao}" /></h2>
    <c:if test="${acao=='Cadastrar'}">
      <form action="FrontController?action=SalvarContato" method="post">
    </c:if>
    <c:if test="${acao=='Editar'}">
      <form action="FrontController?action=AtualizarContato&id=${contato.id}" method="post">
    </c:if>
      <table>
        <tr>
          <td>Telefone</td>
          <td><input type="text" name="txtTelefone" <c:if test="${contato.telefone != null}"> value="${contato.telefone}"</c:if> /></td>
        </tr>
        <tr>
          <td>DDD</td>
          <td><input type="text" name="txtDdd" <c:if test="${contato.ddd != null}"> value="${contato.ddd}"</c:if> /></td>
        </tr>
        <tr>
          <td>Email</td>
          <td><input type="text" name="txtEmail" <c:if test="${contato.email != null}"> value="${contato.email}"</c:if> /></td>
        </tr>
         <tr>
          <td>Telefone Complementar</td>
          <td><input type="text" name="txtTelefoneComplementar" <c:if test="${contato.telefoneComplementar != null}"> value="${contato.telefoneComplementar}"</c:if> /></td>
        </tr>
        <tr>
          <td><input type="submit" value="${acao}" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>
