<%-- 
    Document   : editarDados
    Created on : 09/04/2019, 15:09:29
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Admin - Editar dados</title>
        <%@ include file="shared/head.jsp" %>

    </head>
    <body>
        <%@ include file="shared/navbar.jsp" %>

        <div class="accordion container my-5" id="accordionExample">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h2 class="mb-0">
                        <button class="btn btn-lg btn-dark btn-block" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Dados
                        </button>
                    </h2>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                    <div class="card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="headingTwo">
                    <h2 class="mb-0">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Collapsible Group Item #2
                        </button>
                    </h2>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                    <div class="card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="headingThree">
                    <h2 class="mb-0">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            Collapsible Group Item #3
                        </button>
                    </h2>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                    <div class="card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                </div>
            </div>
        </div>

        <div class="container mt-5">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#nav-dados" aria-controls="nav-dados"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#nav-endereco" aria-controls="nav-endereco">Endereço</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#nav-contato" aria-controls="nav-contato">Contato</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#nav-senha" aria-controls="nav-senha">Senha</a>
                </li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade show active" id="nav-dados" role="tabpanel">
                    <form class="container" action="FrontController?action=EditarDadosLoja" method="post">
                        <div class="row">
                            <div class="col-md-6 text-center">
                                <img src="${loja.imagem}" class="img-fluid profile-image" style="border: 1px solid #f5f5f5;" alt="">
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtImagem">Nova imagem</label>
                                    <input type="text" name="txtImagem" id="txtImagem" <c:if test="${loja.imagem != null}"> value="${loja.imagem}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="txtNome">Nome</label>
                                        <input type="text" name="txtNome" id="txtNome" <c:if test="${loja.nome != null}">
                                           value="${loja.nome}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="txtCnpj">CNPJ</label>
                                        <input type="text" name="txtCnpj" id="txtCnpj" <c:if test="${loja.cnpj != null}">
                                           value="${loja.cnpj}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="optCategoria">Categoria</label>
                                    <select class="custom-select" name="optCategoria" id="optCategoria">
                                    <c:forEach items="${categorias}" var="categoria">
                                        <option <c:if test="${loja.categoria.id == categoria.id}"> selected </c:if> value="${categoria.id}"> ${categoria.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="txtDescricao">Descrição</label>
                                    <input type="text" class="form-control" id="txtDescricao" name="txtDescricao" <c:if
                                               test="${loja.descricao != null}"> value="${loja.descricao}"</c:if> placeholder="Descrição" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-right">
                                    <button type="submit" class="btn btn-md btn-success">Salvar</button>
                                    <a href="FrontController?action=EntrarLoja" class="btn btn-md btn-danger">Cancelar</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="nav-endereco" role="tabpanel">
                        <form class="container" action="FrontController?action=EditarEnderecoLoja" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtLogradouro">Logradouro</label>
                                        <input type="text" name="txtLogradouro" id="txtLogradouro" 
                                        <c:if test="${loja.enderecoLoja.logradouro != null}"> value="${loja.enderecoLoja.logradouro}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtNumero">Numero</label>
                                        <input type="text" name="txtNumero" id="txtNumero" 
                                        <c:if test="${loja.enderecoLoja.numero != null}"> value="${loja.enderecoLoja.numero}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtComplemento">Complemento</label>
                                        <input type="text" name="txtComplemento" id="txtComplemento" <c:if
                                               test="${loja.enderecoLoja.complemento != null}"> value="${loja.enderecoLoja.complemento}"
                                           </c:if> class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtBairro">Bairro</label>
                                    <input type="text" name="txtBairro" id="txtBairro" 
                                           <c:if test="${loja.enderecoLoja.bairro != null}"> value="${loja.enderecoLoja.bairro}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtCidade">Cidade</label>
                                        <input type="text" name="txtCidade" id="txtCidade" 
                                        <c:if test="${loja.enderecoLoja.cidade != null}"> value="${loja.enderecoLoja.cidade}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtEstado">Estado</label>
                                        <input type="text" name="txtEstado" id="txtEstado" 
                                        <c:if test="${loja.enderecoLoja.estado != null}"> value="${loja.enderecoLoja.estado}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtPais">Pais</label>
                                        <input type="text" name="txtPais" id="txtPais" 
                                        <c:if test="${loja.enderecoLoja.pais != null}"> value="${loja.enderecoLoja.pais}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtCep">CEP</label>
                                        <input type="text" name="txtCep" id="txtCep" 
                                        <c:if test="${loja.enderecoLoja.cep != null}"> value="${loja.enderecoLoja.cep}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-right">
                                    <button type="submit" class="btn btn-md btn-success">Salvar</button>
                                    <a href="FrontController?action=EntrarLoja" class="btn btn-md btn-danger">Cancelar</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="nav-contato" role="tabpanel">
                        <form class="container" action="FrontController?action=EditarContatoLoja" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtDdd">DDD</label>
                                        <input type="text" name="txtDdd" id="txtDdd" <c:if test="${loja.contato.ddd != null}">
                                           value="${loja.contato.ddd}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtTelefone">Telefone</label>
                                        <input type="text" name="txtTelefone" id="txtTelefone" <c:if
                                               test="${loja.contato.telefone!= null}"> value="${loja.contato.telefone}"</c:if>
                                               class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtEmail">Email</label>
                                        <input type="text" name="txtEmail" id="txtEmail" <c:if
                                               test="${loja.contato.email != null}">
                                               value="${loja.contato.email}"</c:if> class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtTelefoneComplementar">Telefone complementar</label>
                                        <input type="text" name="txtTelefoneComplementar" id="txtTelefoneComplementar" <c:if
                                               test="${loja.contato.telefoneComplementar!= null}">
                                               value="${loja.contato.telefoneComplementar}"</c:if>
                                           class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-right">
                                <button type="submit" class="btn btn-md btn-success">Salvar</button>
                                <button type="submit" class="btn btn-md btn-danger">Cancelar</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade" id="nav-senha" role="tabpanel">
                    <form class="container" action="FrontController?action=EditarSenhaLoja  " method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtNovaSenha">Nova senha</label>
                                    <input type="text" name="txtNovaSenha" id="txtNovaSenha" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtNovaSenha">Confirmar senha</label>
                                    <input type="text" name="txtNovaSenha2" id="txtNovaSenha2" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-right">
                                <button type="submit" class="btn btn-md btn-success">Salvar</button>
                                <button type="submit" class="btn btn-md btn-danger">Cancelar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>