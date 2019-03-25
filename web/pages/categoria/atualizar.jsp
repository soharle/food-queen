<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Atualizar Categoria</title>
  </head>
  <body>
    <h2>Atualizar</h2>
    <form action="./FrontController?action=AtualizaCategoria&id=${categoria.id}" method="post">
      <table>
        <tr>
          <td>ID</td>
          <td><input type="text" name="id" /></td>
        </tr>
        <tr>
          <td>Nome da categoria</td>
          <td><input type="text" name="txtNome" /></td>
        </tr>
        <tr>
          <td><input type="submit" value="Atualizar" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>
