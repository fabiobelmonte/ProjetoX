/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.MovimentoEstoque;
import com.fbp.projetox.Entidade.Produto;
import com.fbp.projetox.Enums.EntradaSaida;
import com.fbp.projetox.Repositorio.MovimentosEstoque;
import com.fbp.projetox.Repositorio.Produtos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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

    private BigDecimal saldoEstoque = BigDecimal.ZERO;

    @Getter
    @Setter
    private Date dataIncial;
    @Getter
    @Setter
    private Date dataFinal;

    private BigDecimal check(BigDecimal valor) {
        return valor != null ? valor : BigDecimal.ZERO;
    }

    @Inject
    MovimentosEstoque movimentosEstoques;

    @Inject
    Produtos produtos;

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
        atualizaSaldoProduto();
        movimentoEstoque = new MovimentoEstoque();/*Zerar campos da tela de imputar saldos*/
    }

    public void atualizaSaldoProduto() {

        /*CONSULTA DE ESTOQUE PARA ATUALIZAÇÃO*/
        List<Produto> prods = produtos.getSaldoProduto(movimentoEstoque.getProduto().getId());
        for (Produto produto : prods) {

            BigDecimal saldo = check(produto.getSaldoEstoque());
            System.out.println(saldo);

            if ((saldo.compareTo(BigDecimal.ZERO) == 1)) {
                System.out.println("1");
                saldoEstoque = check(produto.getSaldoEstoque());
                System.out.println("SALDO ESTOQUE 1: " + saldoEstoque);

            } else {
                System.out.println("2");
                saldoEstoque = BigDecimal.ZERO;
                System.out.println("SALDO ESTOQUE 2: " + saldoEstoque);

            }

            /*VERIFICO O SALDO DO PRODUTO EM QUESTÃO, CASO HAJA ESTOQUE SOMO A QUANTIDADE NOVA COM A ATUAL, SENÃO APENAS ADICIONO O VALOR A VARIAVEL 'SALDOESTOQUE'*/
            if (saldoEstoque.compareTo(BigDecimal.ZERO) == 1) {
                System.out.println("3");
                saldoEstoque = saldoEstoque.add(movimentoEstoque.getQuantidadeMovimentada());
                System.out.println("SALDO ESTOQUE 3: " + saldoEstoque);

            } else {
                System.out.println("4");
                saldoEstoque = check(movimentoEstoque.getQuantidadeMovimentada());
                System.out.println("SALDO ESTOQUE 4: " + saldoEstoque);
            }

            produto.setSaldoEstoque(saldoEstoque);
            produtos.save(produto);
            produto = new Produto();
        }

    }

    public void buscaMovimentacao() {
        listaMovimentos = movimentosEstoques.pesquisaMovimentacao(prod, dataIncial, dataFinal);
    }

}
