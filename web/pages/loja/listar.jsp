<%-- 
    Document   : listar
    Created on : 28/03/2019, 12:16:08
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lojas</title>
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
              Descrição:
            </th>
            <th>
              Excluir
            </th>
            <th>
              Visualizar
            </th>
          </thead>
          <tbody>
            <c:forEach items="${lojas}" var="loja">
              <tr>
                <td><c:out value="${loja.id}"/></td>
                <td><c:out value="${loja.nome}"/></td>
                <td><c:out value="${loja.descricao}"/></td>
                <td
                  ><form
                    action="FrontController?action=DeletarLoja&id=${loja.id}"
                    method="post"
                  >
                    <input type="submit" value="X" /> </form
                ></td>
                <td
                  ><form
                    action="FrontController?action=LerLoja&id=${loja.id}"
                    method="post"
                  >
                    <input type="submit" value="Visualizar" /> </form
                ></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <form action="FrontController?action=CadastrarLoja"
      method="post">
      <input type="submit" value="Cadastrar">
      </form>
    </div>
  </body>
</html>
