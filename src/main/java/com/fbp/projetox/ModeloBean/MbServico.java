/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Servico;
import com.fbp.projetox.Repositorio.Servicos;
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
public class MbServico implements Serializable {

    @Inject
    Servicos servicos;

    @Getter
    @Setter
    Servico servico;

    public MbServico() {
        servico = new Servico();
    }

    public void salvar() {
        servicos.save(servico);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("Gazes", new FacesMessage("Ocorrencia Cadastrada com Sucesso!"));
        servico = new Servico();
    }

    public void editarServico() {
        if (servico == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione um Serviço primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }
}
