<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title> <c:out value="${acao}"/> Promoção</title>
  </head>
  <body>
    <h2> <c:out value="${acao}" /></h2>
    <c:if test="${acao=='Cadastrar'}">
      <form action="FrontController?action=SalvarPromocao" method="post">
    </c:if>
    <c:if test="${acao=='Editar'}">
      <form action="FrontController?action=AtualizarPromocao&id=${promocao.id}" method="post">
    </c:if>
      <table>
        <tr>
          <td>Nome da promocao</td>
          <td><input type="text" name="txtNome" <c:if test="${promocao.nome != null}"> value="${promocao.nome}"</c:if> /></td>
        </tr>
        <tr>
          <td>Desconto</td>
          <td><input type="text" name="txtDesconto" <c:if test="${promocao.desconto != null}"> value="${promocao.desconto}"</c:if> /></td>
        </tr>
        <tr>
          <td>Tipo</td>
          <td>
              <select name="optTipo">
                <option value="Valor bruto" <c:if test="${promocao.tipo == 'Valor bruto'}"> selected </c:if>>Valor bruto</option>
                <option value="Porcentagem" <c:if test="${promocao.tipo == 'Porcentagem'}"> selected </c:if>>Porcentagem</option>
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
