/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conta;

/**
 *
 * @author mathe
 */
public class TipoContaLoja extends TipoConta {

    public TipoContaLoja() {
        this.listaPermissao.add(TipoLoginLoja.getTipoLoginLoja());
        this.setContaSuperior(null);
    }

    @Override
    public String getDescricaoConta() {
        return "Loja";
    }

}
