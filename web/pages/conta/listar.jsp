<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Contas</title>
  </head>
  <body>
    <div>
      <h1>Contas</h1>
      <div>
        <table class="tableCrud">
          <thead>
            <th>
              Id:
            </th>
            <th>
              Login:
            </th>
            <th>
              Excluir
            </th>
            <th>
              Visualizar
            </th>
          </thead>
          <tbody>
            <c:forEach items="${contas}" var="conta">
              <tr>
                <td><c:out value="${conta.id}"/></td>
                <td><c:out value="${conta.login}"/></td>
                <td
                  ><form
                    action="FrontController?action=DeletarConta&id=${conta.id}"
                    method="post"
                  >
                    <input type="submit" value="X" /> </form
                ></td>
                <td
                  ><form
                    action="FrontController?action=LerConta&id=${conta.id}"
                    method="post"
                  >
                    <input type="submit" value="Visualizar" /> </form
                ></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <form action="FrontController?action=CadastrarConta"
      method="post">
      <input type="submit" value="Cadastrar">
      </form>
    </div>
  </body>
</html>
