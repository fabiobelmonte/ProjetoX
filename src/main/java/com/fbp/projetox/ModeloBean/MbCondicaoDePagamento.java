/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.CondicaoDePagamento;
import com.fbp.projetox.Repositorio.CondicoesDePagamentos;
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
public class MbCondicaoDePagamento implements Serializable {

    @Inject
    CondicoesDePagamentos condicoesDePagamentos;

    @Getter
    @Setter
    CondicaoDePagamento condicaoDePagamento;

    public MbCondicaoDePagamento() {
        condicaoDePagamento = new CondicaoDePagamento();
    }

    public void salvar() {
        condicoesDePagamentos.save(condicaoDePagamento);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Condição de Pagamento Cadastrada com Sucesso!"));
        condicaoDePagamento = new CondicaoDePagamento();

    }

    public void editarCondicaoDePagamento() {
        if (condicaoDePagamento == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma Condição de Pagamento primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }

}
