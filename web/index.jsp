<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="./assets/images/foodqueen.png">
        <title>FoodeQueen - Login</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="assets/css/mdb.min.css" rel="stylesheet">
        <!-- Your custom styles (optional) -->
        <link href="assets/css/sigin.css" rel="stylesheet">
        <style>
            html,
            body {
                height: 100%;
            }

            .box {
                padding: 75px;
                background-color: rgba(167, 164, 154, 0.85); 

            }

            body {
                display: -ms-flexbox;
                display: -webkit-box;
                display: flex;
                -ms-flex-align: center;
                -ms-flex-pack: center;
                -webkit-box-align: center;
                align-items: center;
                -webkit-box-pack: center;
                justify-content: center;
                padding-top: 40px;
                padding-bottom: 40px;
                background-image: url("./assets/images/bg-login.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }

            .form-signin {
                width: 100%;
                max-width: 330px;
                padding: 15px;
                margin: 0 auto;
            }

            .form-signin .checkbox {
                font-weight: 400;
            }

            .form-signin .form-control {
                position: relative;
                box-sizing: border-box;
                height: auto;
                padding: 10px;
                font-size: 16px;
            }

            .form-signin .form-control:focus {
                z-index: 2;
            }

            .form-signin input[type="email"] {
                margin-bottom: -1px;
                border-bottom-right-radius: 0;
                border-bottom-left-radius: 0;
            }

            .form-signin input[type="password"] {
                margin-bottom: 10px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
        </style>

    </head>

    <body class="text-center">
        <div class="text-center">
            <div class="box">
                <h1 class="mb-3 font-weight-bold">FoodQueen
                </h1>
                <br />
                <form  action="FrontController?action=LogarConta" method="post" id="form1" class="form-signin">
                    <span id="lblMsg"></span>
                    <label for="txtLogin" class="sr-only">
                        <b>Usuário:
                        </b>
                    </label>
                    <input name="txtLogin" type="text"  class="form-control mb-1" placeholder="Usuário" required="" />
                    <label for="txtSenha" class="sr-only">
                        <b>Senha:
                        </b>
                    </label>
                    <input name="txtSenha" type="password" class="form-control" placeholder="Senha" required="" />
                    <button type="submit" value="submit" class="btn btn-lg btn-outline-elegant btn-block">Entrar</button>
                    <a href="FrontController?action=CadastrarConsumidor" class="btn btn-lg btn-info btn-block mt-5">Cadastrar usuário</a>
                    <a href="FrontController?action=CadastrarLoja" class="btn btn-lg btn-success btn-block">Cadastrar restaurante</a>

                </form>

            </div>
        </div>

        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>

</html>