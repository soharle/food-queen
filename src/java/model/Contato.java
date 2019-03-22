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
public class Contato {
    long id;
    String telefone;
    String ddd;
    String email;
    String telefoneComplementar;

    public Contato(long id, String telefone, String ddd, String email, String telefoneComplementar) {
        this.id = id;
        this.telefone = telefone;
        this.ddd = ddd;
        this.email = email;
        this.telefoneComplementar = telefoneComplementar;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneComplementar() {
        return telefoneComplementar;
    }

    public void setTelefoneComplementar(String telefoneComplementar) {
        this.telefoneComplementar = telefoneComplementar;
    }
    
}
