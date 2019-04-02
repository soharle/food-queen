<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Endereços de Loja</title>
  </head>
  <body>
    <div>
      <h1>Endereços de Loja</h1>
      <div>
        <table class="tableCrud">
          <thead>
            <th>
              Id:
            </th>
            <th>
              Logradouro:
            </th>
            <th>
              Cidade:
            </th>
            <th>
              Excluir
            </th>
            <th>
              Visualizar
            </th>
          </thead>
          <tbody>
            <c:forEach items="${enderecosLoja}" var="enderecoLoja">
              <tr>
                <td><c:out value="${enderecoLoja.id}"/></td>
                <td><c:out value="${enderecoLoja.logradouro}"/></td>
                <td><c:out value="${enderecoLoja.cidade}"/></td>
                <td
                  ><form
                    action="FrontController?action=DeletarEnderecoLoja&id=${enderecoLoja.id}"
                    method="post"
                  >
                    <input type="submit" value="X" /> </form
                ></td>
                <td
                  ><form
                    action="FrontController?action=LerEnderecoLoja&id=${enderecoLoja.id}"
                    method="post"
                  >
                    <input type="submit" value="Visualizar" /> </form
                ></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <form action="FrontController?action=CadastrarEnderecoLoja"
      method="post">
      <input type="submit" value="Cadastrar">
      </form>
    </div>
  </body>
</html>
