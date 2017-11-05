/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Empresa;
import com.fbp.projetox.Entidade.Marca;
import com.fbp.projetox.Repositorio.Empresas;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.Update;

/**
 *
 * @author F.Belmonte
 */
@Named
@ViewScoped
public class MbEmpresa implements Serializable {

    @Inject
    Empresas empresas;

    @Getter
    @Setter
    Empresa empresa;

    List<Empresa> listaEmpresas;

    public List<Empresa> getListaEmpresas() {
        return empresas.findAll();
    }

    public MbEmpresa() {
        empresa = new Empresa();
    }

    public void salvar() {
        empresas.save(empresa);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Empresa Cadastrada com Sucesso!"));
        empresa = new Empresa();
    }

    public void cadastrarFilial() {
        if (empresa == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma empresa para cadastrar uma Filial!"));
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastrofilial').show()");
        }
    }

   
}
