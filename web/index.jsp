<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <head>
        <title>Index</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <ul>
            <li><a href="FrontController?action=PrepararCategoria"> Categorias </a></li>
            <li><a href="FrontController?action=PrepararConta"> Conta </a></li>
            <li><a href="FrontController?action=PrepararContato"> Contato</a></li>
            <li><a href="FrontController?action=PrepararPromocao"> Promoções </a></li>
            <li><a href="FrontController?action=PrepararEnderecoLoja"> Endereços de Loja </a></li>
            <li><a href="FrontController?action=PrepararLoja"> Lojas </a></li>

        </ul>
    </body>
</html>
