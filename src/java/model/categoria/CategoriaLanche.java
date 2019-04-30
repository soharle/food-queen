/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.categoria;

/**
 *
 * @author mathe
 */
public class CategoriaLanche extends Categoria{
    @Override
    public String getDescricao() {
        return "Vende hambúrguers, batatas e sanduíches em geral.";
    }
    
    public CategoriaLanche(){
        this.setNome("Lanche");
    }
    
}
