<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title> Login </title>
  </head>
  <body>
    <h2> Login </h2>
      <form action="../../FrontController?action=LogarConta" method="post">
      <table>
        <tr>
          <td>Login</td>
          <td><input type="text" name="txtLogin" /></td>
        </tr>
        <tr>
          <td>Senha</td>
          <td><input type="text" name="txtSenha" /></td>
        </tr>
        <tr>
          <td><input type="submit" value="Logar" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>
