<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Categorias</title>
  </head>
  <body>
    <div>
      <h1>Categorias</h1>
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
              Excluir
            </th>
          </thead>
          <tbody>
            <c:forEach items="${categorias}" var="categoria">
              <tr>
                <td><c:out value="${categoria.id}"/></td>
                <td><c:out value="${categoria.nome}"/></td>
                <td
                  ><form
                    action="FrontController?action=DeletarCategoria&id=${categoria.id}"
                    method="post"
                  >
                    <input type="submit" value="X" /> </form
                ></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
