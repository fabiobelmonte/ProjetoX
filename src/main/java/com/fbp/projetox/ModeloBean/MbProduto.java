/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Produto;
import com.fbp.projetox.Entidade.SimNao;
import com.fbp.projetox.Entidade.Situacao;
import com.fbp.projetox.Repositorio.Produtos;
import java.io.Serializable;
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
public class MbProduto implements Serializable {

    @Inject
    Produtos produtos;

    @Getter
    @Setter
    Produto produto;

    @Getter
    private final Situacao[] situacao;
    
    @Getter
    private final SimNao[] simNao;
    List<Produto> listaProdutos;

    public List<Produto> getListaProdutos() {
        return produtos.findAll();
    }

    public MbProduto() {
        produto = new Produto();
        situacao = Situacao.values();
        simNao = SimNao.values();
    }

    public void salvar() {
        produtos.save(produto);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("Gazes", new FacesMessage("Produto Cadastrado com Orgasmosss!"));
        produto = new Produto();

    }

}
