<%-- 
    Document   : navbar
    Created on : 09/04/2019, 13:49:49
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color: #111111;">
    <a class="navbar-brand" href="FrontController?action=EntrarLoja">
        <img src="./assets/images/foodqueen.png" width="30" height="30" class="d-inline-block align-top" alt="">
        FoodQueen
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="FrontController?action=EntrarLoja">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="FrontController?action=PrepararEditarLoja">Editar dados</a>
            </li>
        </ul>
        <span class="navbar-text">
            ${sessionScope.nomeLoja}
        </span>
        <form class="form-inline my-2 my-lg-0" action="FrontController?action=DeslogarConta" method="post">
            <button class="btn btn-outline-danger btn-sm my-2 my-sm-0" type="submit">Logout</button>
        </form>
    </div>
</nav>
