/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.TipoServico;
import com.fbp.projetox.Repositorio.TipoServicos;
import java.io.Serializable;
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
public class MbTipoServico implements Serializable {

    @Inject
    TipoServicos tipoServicos;

    @Getter
    @Setter
    TipoServico tipoServico;

    public MbTipoServico() {
        tipoServico = new TipoServico();
    }

    public void salvar() {
        tipoServicos.save(tipoServico);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Tipo de Serviço Cadastrado com Sucesso!"));
        tipoServico = new TipoServico();
    }

    public void editarTipoServico() {
        if (tipoServico == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma Marca primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }
}
