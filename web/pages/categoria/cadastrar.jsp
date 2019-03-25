<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Cadastrar Categoria</title>
  </head>
  <body>
    <h2>Cadastrar</h2>
    <form action="../../FrontController?action=SalvarCategoria" method="post">
      <table>
        <tr>
          <td>Nome da categoria</td>
          <td><input type="text" name="txtNome" /></td>
        </tr>
        <tr>
          <td><input type="submit" value="Cadastrar" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>
