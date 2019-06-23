/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ContatoDAO;

/**
 *
 * @author mathe
 */
public class Contato {

    private long id;
    private String telefone;
    private String ddd;
    private String email;
    private String telefoneComplementar;

    public long getId() {
        return id;
    }

    public Contato setId(long id) {
        this.id = id;
        return this;

    }

    public String getTelefone() {
        return telefone;
    }

    public Contato setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getDdd() {
        return ddd;
    }

    public Contato setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contato setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefoneComplementar() {
        return telefoneComplementar;
    }

    public Contato setTelefoneComplementar(String telefoneComplementar) {
        this.telefoneComplementar = telefoneComplementar;
        return this;
    }

    public void save() {
        ContatoDAO.getInstance().save(this);
    }

    public void update() {
        ContatoDAO.getInstance().update(this);
    }

    public void delete() {
        ContatoDAO.getInstance().delete(this.id);
    }

    public Contato get() {
        return ContatoDAO.getInstance().get(id);
    }

    public static ArrayList<Contato> getAll() {
        return ContatoDAO.getInstance().getAll();
    }

}
