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
public class TipoContaConsumidor extends TipoConta {

    public TipoContaConsumidor() {
        this.listaPermissao.add(TipoLoginConsumidor.getTipoLoginConsumidor());
        this.setContaSuperior(new TipoContaLoja());
    }

    @Override
    public String getDescricaoConta() {
        return "Consumidor";
    }
    
    

}
