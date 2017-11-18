/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.FormaDePagamento;
import com.fbp.projetox.Repositorio.FormasDePagamentos;
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
public class MbFormaDePagamento implements Serializable {

    @Inject
    FormasDePagamentos formasDePagamentos;

    @Getter
    @Setter
    FormaDePagamento formaDePagamento;

    public MbFormaDePagamento() {
        formaDePagamento = new FormaDePagamento();
    }

    public void salvar() {
        formasDePagamentos.save(formaDePagamento);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Forma de Pagamento Cadastrada com Sucesso!"));
        formaDePagamento = new FormaDePagamento();

    }

    public void editarFormaDePagamento() {
        if (formaDePagamento == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma Forma de Pagamento primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }

}
