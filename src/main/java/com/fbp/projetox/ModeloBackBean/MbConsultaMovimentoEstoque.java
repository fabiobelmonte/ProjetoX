/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Entidade.MovimentoEstoque;
import com.fbp.projetox.Entidade.Produto;
import com.fbp.projetox.Enums.EntradaSaida;
import com.fbp.projetox.Repositorio.MovimentosEstoque;
import com.fbp.projetox.Repositorio.Produtos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class MbConsultaMovimentoEstoque implements Serializable {

    @Getter
    @Setter
    private Date dataIncial;
    @Getter
    @Setter
    private Date dataFinal;

    @Inject
    MovimentosEstoque movimentosEstoques;

    @Inject
    Produtos produtos;

    @Getter
    @Setter
    private Filial filial;

    @Getter
    @Setter
    MovimentoEstoque movimentoEstoque;

    @Getter
    @Setter
    private Produto prod;

    @Getter
    private final EntradaSaida[] entradaSaida;

    List<MovimentoEstoque> listaMovimentosEstoques;

    @Getter
    @Setter
    List<MovimentoEstoque> listaMovimentos;

    @PostConstruct
    public void init() {
        movimentoEstoque.setDataMovimento(new Date());
    }

    public MbConsultaMovimentoEstoque() {
        movimentoEstoque = new MovimentoEstoque();
        entradaSaida = EntradaSaida.values();
    }

    public void buscaMovimentacao() {
        listaMovimentos = movimentosEstoques.pesquisaMovimentacao(prod, dataIncial, dataFinal, filial);
    }

}
