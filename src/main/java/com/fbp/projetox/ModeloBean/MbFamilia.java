/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Familia;
import com.fbp.projetox.Repositorio.Familias;
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
public class MbFamilia implements Serializable {

    @Inject
    Familias familias;

    @Getter
    @Setter
    Familia familia;

    List<Familia> listaFamilias;

    public List<Familia> getListaFamilias() {
        return familias.findAll();
    }

    public MbFamilia() {
        familia = new Familia();
    }

    public void salvar() {
        familias.save(familia);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Família Cadastrada com Sucesso!"));
        familia = new Familia();

    }

    public void editarFamilia() {
        if (familia == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma Familia primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }

}
