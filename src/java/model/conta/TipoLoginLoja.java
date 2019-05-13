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
public class TipoLoginLoja implements TipoLogin {

    private static TipoLoginLoja tipoLoginLoja = new TipoLoginLoja();

    public static TipoLoginLoja getTipoLoginLoja() {
        return tipoLoginLoja;
    }

}
