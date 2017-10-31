/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.MovimentoEstoque;
import com.fbp.projetox.Enums.EntradaSaida;
import com.fbp.projetox.Repositorio.MovimentosEstoque;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class MbMovimentoEstoque implements Serializable {

    @Inject
    MovimentosEstoque movimentosEstoques;

    @Getter
    @Setter
    MovimentoEstoque movimentoEstoque;

    @Getter
    private final EntradaSaida[] entradaSaida;

    List<MovimentoEstoque> listaMovimentosEstoques;

    public List<MovimentoEstoque> getListaMovimentoEstoque() {
        return movimentosEstoques.findAll();
    }

    public MbMovimentoEstoque() {
        movimentoEstoque = new MovimentoEstoque();
        entradaSaida = EntradaSaida.values();
    }

    public void salvar() {

        movimentosEstoques.save(movimentoEstoque);

        FacesContext ctx = FacesContext.getCurrentInstance();
        if (movimentoEstoque.getTipoMovimento().getDescricao().equals("Entrada")) {
            ctx.addMessage("Sucesso", new FacesMessage("Movimento de Entrada realizado com sucesso!"));
        } else {
            ctx.addMessage("Sucesso", new FacesMessage("Movimento de Saída realizado com sucesso!"));
            movimentoEstoque.setQuantidadeMovimentada(movimentoEstoque.getQuantidadeMovimentada().multiply(BigDecimal.valueOf(-1)));
            movimentosEstoques.save(movimentoEstoque);
        }

        movimentoEstoque = new MovimentoEstoque();/*Zerar campos da tela de imputar saldos*/
    }

}
