/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Entidade.Marca;
import com.fbp.projetox.Entidade.Produto;
import com.fbp.projetox.Enums.SimNao;
import com.fbp.projetox.Enums.Situacao;

import com.fbp.projetox.Repositorio.Produtos;
import java.io.Serializable;
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
public class MbProduto implements Serializable {

    @Inject
    Produtos produtos;

    @Inject
    MbSelecionaFilial mbSelecionaFilial;

    @Getter
    @Setter
    private Produto produto;

    @Getter
    @Setter
    private Filial filial;

    @Getter
    @Setter
    private Marca marca;

    @Getter
    @Setter
    List<Produto> listaSaldoProdutos;

    @Getter
    private final Situacao[] situacao;

    @Getter
    private final SimNao[] simNao;

    List<Produto> listaProdutos;

    @Getter
    List<Produto> listaProdutoMarca;

    public List<Produto> getListaProdutos() {
        return produtos.getProdutoFilial(mbSelecionaFilial.getFilial());
    }

    public MbProduto() {
        situacao = Situacao.values();
        simNao = SimNao.values();
    }

    public void salvar() {
        produtos.save(produto);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("Informação", new FacesMessage("Produto Cadastrado/Alterado com Sucesso!"));
        produto = new Produto();
    }

    public void init() {
        produto = new Produto();
        produto.setDataCadastro(new Date());
    }

    public void novoProduto() {
        produto = new Produto();

    }

    public void editarProduto() {

        if (produto == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione um Produto primeiro!"));
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastroproduto').show()");
        }
    }

    public void buscaSaldos() {
        listaSaldoProdutos = produtos.pesquisaSaldoProduto(marca, produto, filial);
    }

    public void pesquisaProdutoMarca() {
        listaProdutoMarca = produtos.getProdutoMarca(marca, mbSelecionaFilial.getFilial());
    }
}
