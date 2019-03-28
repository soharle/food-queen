<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title> <c:out value="${acao}"/> Conta</title>
  </head>
  <body>
    <h2> <c:out value="${acao}" /></h2>
    <c:if test="${acao=='Cadastrar'}">
      <form action="FrontController?action=SalvarConta" method="post">
    </c:if>
    <c:if test="${acao=='Editar'}">
      <form action="FrontController?action=AtualizarConta&id=${conta.id}" method="post">
    </c:if>
      <table>
        <tr>
          <td>Login</td>
          <td><input type="text" name="txtLogin" <c:if test="${conta.login != null}"> value="${conta.login}"</c:if> /></td>
        </tr>
        <tr>
          <td>Senha</td>
          <td><input type="text" name="txtSenha" <c:if test="${conta.senha != null}"> value="${conta.senha}"</c:if> /></td>
        </tr>
        <tr>
          <td>Tipo</td>
          <td>
              <select name="optTipo" <c:if test="${acao=='Editar'}"> disabled </c:if>>
                <option value="Loja" <c:if test="${conta.tipo == 'Loja'}"> selected </c:if>>Loja</option>
                <option value="Consumidor" <c:if test="${conta.tipo == 'Consumidor'}"> selected </c:if>>Consumidor</option>
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
