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
public class TipoLoginConsumidor implements TipoLogin {

    private static TipoLoginConsumidor tipoLoginConsumidor = new TipoLoginConsumidor();

    public static TipoLoginConsumidor getTipoLoginConsumidor() {
        return tipoLoginConsumidor;
    }

}
