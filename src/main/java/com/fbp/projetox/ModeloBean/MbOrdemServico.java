/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.OrdemServico;
import com.fbp.projetox.Repositorio.OrdemServicos;
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
public class MbOrdemServico implements Serializable {

    @Inject
    OrdemServicos ordenServicos;

    @Getter
    @Setter
    OrdemServico ordemServico;

    public MbOrdemServico() {
        ordemServico = new OrdemServico();
    }

    public void salvar() {
        ordenServicos.save(ordemServico);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("Gazes", new FacesMessage("Ocorrencia Cadastrada com Sucesso!"));
        ordemServico = new OrdemServico();
    }

    public void editarFamilia() {
        if (ordemServico == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma Marca primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }
}
