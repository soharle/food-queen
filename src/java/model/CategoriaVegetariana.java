/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mathe
 */
public class CategoriaVegetariana extends Categoria {

    @Override
    public String getDescricao() {
        return "Vende pratos que não utilizam carne";
    }
    
    public CategoriaVegetariana(){
        this.setNome("Vegetariana");
    }
}
