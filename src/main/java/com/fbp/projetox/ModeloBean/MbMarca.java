/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Marca;
import com.fbp.projetox.Repositorio.Marcas;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author F.Belmonte
 */
@Named
@ViewScoped
public class MbMarca implements Serializable {

    @Inject
    Marcas marcas;

    @Getter
    @Setter
    Marca marca;

    List<Marca> listaMarcas;

    public List<Marca> getListaMarcas() {
        return marcas.findAll();
    }

    public MbMarca() {
        marca = new Marca();
    }

    public void salvar() {
        marcas.save(marca);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("Gazes", new FacesMessage("Marca Cadastrada com Sucesso!"));
        marca = new Marca();
    }

    public void editarFamilia() {
        if (marca == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma Marca primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }
}
