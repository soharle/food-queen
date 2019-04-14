<%-- 
    Document   : editarDados
    Created on : 09/04/2019, 15:09:29
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Admin - Home</title>
        <%@ include file="shared/head.jsp" %>

    </head>


    <body>
        <%@ include file="shared/navbar.jsp" %>
        <div class="container my-5">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-item nav-link active" id="nav-dados-tab" data-toggle="tab" href="#nav-dados" role="tab" aria-controls="nav-dados" aria-selected="true">Dados</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item nav-link" id="nav-endereco-tab" data-toggle="tab" href="#nav-endereco" role="tab" aria-controls="nav-endereco" aria-selected="false">Endereço</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item nav-link" id="nav-contato-tab" data-toggle="tab" href="#nav-contato" role="tab" aria-controls="nav-contato" aria-selected="false">Contato</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item nav-link" id="nav-senha-tab" data-toggle="tab" href="#nav-senha" role="tab" aria-controls="nav-senha" aria-selected="false">Senha</a>
                </li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade show active" id="nav-dados" role="tabpanel" aria-labelledby="nav-dados-tab">
                    <form class="container" action="FrontController?action=EditarDadosLoja" method="post">
                        <div class="row">
                            <div class="col-md-6 text-center">
                                <img src="${loja.imagem}" class="img-fluid profile-image" style="border: 1px solid #f5f5f5;"
                                     alt="">
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtImagem">Nova imagem</label>
                                    <input type="text" name="txtImagem" id="txtImagem" <c:if test="${loja.imagem != null}">
                                           value="${loja.imagem}"</c:if> class="form-control"/>
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
                    <div class="tab-pane fade" id="nav-endereco" role="tabpanel" aria-labelledby="nav-endereco-tab">
                        <form class="container" action="FrontController?action=EditarEnderecoLoja" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtLogradouro">Logradouro</label>
                                        <input type="text" name="txtLogradouro" id="txtLogradouro" <c:if
                                               test="${loja.endereco.logradouro != null}"> value="${loja.endereco.logradouro}"
                                           </c:if> class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtNumero">Numero</label>
                                    <input type="text" name="txtNumero" id="txtNumero" <c:if
                                               test="${loja.endereco.numero != null}"> value="${loja.endereco.numero}"</c:if>
                                               class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtComplemento">Complemento</label>
                                        <input type="text" name="txtComplemento" id="txtComplemento" <c:if
                                               test="${loja.endereco.complemento != null}"> value="${loja.endereco.complemento}"
                                           </c:if> class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group mt-5">
                                    <label for="txtBairro">Bairro</label>
                                    <input type="text" name="txtBairro" id="txtBairro" <c:if
                                               test="${loja.endereco.bairro != null}"> value="${loja.endereco.bairro}"</c:if>
                                               class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtCidade">Cidade</label>
                                        <input type="text" name="txtCidade" id="txtCidade" <c:if
                                               test="${loja.endereco.cidade != null}"> value="${loja.endereco.cidade}"</c:if>
                                               class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtEstado">Estado</label>
                                        <input type="text" name="txtEstado" id="txtEstado" <c:if
                                               test="${loja.endereco.estado != null}"> value="${loja.endereco.estado}"</c:if>
                                               class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtPais">Pais</label>
                                        <input type="text" name="txtPais" id="txtPais" <c:if
                                               test="${loja.endereco.pais != null}"> value="${loja.endereco.pais}"</c:if>
                                               class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group mt-5">
                                        <label for="txtCep">CEP</label>
                                        <input type="text" name="txtCep" id="txtCep" <c:if test="${loja.endereco.cep != null}">
                                           value="${loja.endereco.cep}"</c:if> class="form-control"/>
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
                    <div class="tab-pane fade" id="nav-contato" role="tabpanel" aria-labelledby="nav-contato-tab">
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
                                <a href="FrontController?action=EntrarLoja" class="btn btn-md btn-danger">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade" id="nav-senha" role="tabpanel" aria-labelledby="nav-senha-tab">
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
                                <a href="FrontController?action=EntrarLoja" class="btn btn-md btn-danger">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>